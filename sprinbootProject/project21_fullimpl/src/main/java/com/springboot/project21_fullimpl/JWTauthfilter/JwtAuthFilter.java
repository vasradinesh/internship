package com.springboot.project21_fullimpl.JWTauthfilter;

import com.springboot.project21_fullimpl.Utils.JWTutility.JwtUtil;
import com.springboot.project21_fullimpl.service.Serviceimpl.MyEmployeeUserDetails;
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
    private MyEmployeeUserDetails myEmployeeUserDetails;
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authtoken = request.getHeader("Authorization");
        System.out.println("token"+authtoken);
        if (authtoken !=null &&authtoken.startsWith("Bearer ")){

            String jwtToken = authtoken.substring(7);

            System.out.println("jwttoken" + jwtToken);

            String username = jwtUtil.extractUsername(jwtToken);

            UserDetails user = myEmployeeUserDetails.loadUserByUsername(username);

            if (user!=null && SecurityContextHolder.getContext().getAuthentication()==null){

                List<String> roles =
                        jwtUtil.extractClaim(jwtToken, claims -> claims.get("roles", ArrayList.class));
                List<SimpleGrantedAuthority> simpleGrantedAuthority =
                        roles.stream().map(r -> new SimpleGrantedAuthority(r)).toList();
                System.out.println(simpleGrantedAuthority);

                if (jwtUtil.validateToken(jwtToken,user)){
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,null,simpleGrantedAuthority);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
