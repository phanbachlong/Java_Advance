package com.vti.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/signup").permitAll()
                        .requestMatchers("/api/v1/departments/**").hasAnyAuthority("ADMIN") // Ch? ADMIN
                        .requestMatchers("/api/v1/departments").hasAnyAuthority("ADMIN")
                        .requestMatchers("/api/v1/accounts/**").hasAnyAuthority("ADMIN") // Ch? ADMIN
                        .requestMatchers("/api/v1/accounts").hasAnyAuthority("ADMIN")
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/api/v1/auth/login").permitAll()
                        .anyRequest().authenticated() // Các API khác ??u yêu c?u xác th?c
                )
                .httpBasic(withDefaults()); // Dùng HTTP Basic Authentication

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}