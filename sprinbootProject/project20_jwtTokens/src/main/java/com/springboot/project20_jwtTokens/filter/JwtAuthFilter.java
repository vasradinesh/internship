package com.springboot.project20_jwtTokens.filter;

import com.springboot.project20_jwtTokens.JWTUtility.JwtUtil;
import com.springboot.project20_jwtTokens.service.serviceimpl.JwtBlackListService;
import com.springboot.project20_jwtTokens.service.serviceimpl.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtBlackListService jwtBlackListService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authToken = request.getHeader("Authorization");
        System.out.println("authToken="+authToken);
        if(authToken !=null && authToken.startsWith("Bearer "))
        {
            String jwtToken=authToken.substring(7);
            System.out.println("JWT Token :"+jwtToken);

            if(jwtBlackListService.isTokenBlacklisted(jwtToken)) {
                System.out.println(jwtBlackListService.isTokenBlacklisted(jwtToken));
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            String userName = jwtUtil.extractUsername(jwtToken);

            UserDetails user=myUserDetailsService.loadUserByUsername(userName);


            if(user !=null && SecurityContextHolder.getContext().getAuthentication()==null)
            {

                List<String> list = jwtUtil.extractClaim(jwtToken, claims -> claims.get("roles", ArrayList.class));

                List<SimpleGrantedAuthority> simpleGrantedAuthority = list.stream().map(r -> new SimpleGrantedAuthority(r)).toList();

                System.out.println(simpleGrantedAuthority);

                if(jwtUtil.validateToken(jwtToken,user))
                {
                    UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(userName,null, simpleGrantedAuthority);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);

                }
            }

        }

        filterChain.doFilter(request,response);

    }
}
