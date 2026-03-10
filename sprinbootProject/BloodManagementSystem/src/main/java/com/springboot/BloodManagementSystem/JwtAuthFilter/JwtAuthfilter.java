package com.springboot.BloodManagementSystem.JwtAuthFilter;

import com.springboot.BloodManagementSystem.JwtUtility.JwtUtil;
import com.springboot.BloodManagementSystem.Service.Serviceimpl.MyUserDetailsService;
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
public class JwtAuthfilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authtoken = request.getHeader("Authorization");

        System.out.println(authtoken);

        if (authtoken!=null &&authtoken.startsWith("Bearer ")){
            String token = authtoken.substring(7);

            String email = jwtUtil.extractUsername(token);

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(email);
            if (userDetails!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                List<String> roles = jwtUtil.extractClaim(token, claims -> claims.get("roles", ArrayList.class));
                List<SimpleGrantedAuthority> simpleGrantedAuthorities =
                        roles.stream().map(m -> new SimpleGrantedAuthority(m)).toList();

                if (jwtUtil.validateToken(token,userDetails)){
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email,null,simpleGrantedAuthorities);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
