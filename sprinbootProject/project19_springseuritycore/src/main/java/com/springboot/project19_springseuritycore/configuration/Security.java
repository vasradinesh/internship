package com.springboot.project19_springseuritycore.configuration;


import com.springboot.project19_springseuritycore.service.serviceimpl.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth.requestMatchers("/getword","/save-student").permitAll())
                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();

    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1 = User.builder()
//                .username("dinesh")
//                .password(passwordEncoder().encode("dinesh@#123"))
//                .roles("admin")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("kevin")
//                .password(passwordEncoder().encode("kevin@#123"))
//                .roles("helper")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(user2,user1);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(MyUserDetailsService myUserDetailsService,PasswordEncoder encoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(myUserDetailsService);
        provider.setPasswordEncoder(encoder);
        return provider;

    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
