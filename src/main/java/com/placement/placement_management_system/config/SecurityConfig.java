package com.placement.placement_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth

                // Public pages and authentication
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/auth.html",
                    "/api/home",
                    "/api/auth/**",
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/favicon.ico"
                ).permitAll()

                // Students
                .requestMatchers("/api/students/**")
                .hasAnyRole("STUDENT", "ADMIN")

                // Companies
                .requestMatchers("/api/companies/**")
                .hasAnyRole("COMPANY", "ADMIN")

                // Jobs
                .requestMatchers(HttpMethod.GET, "/api/jobs/**")
                .hasAnyRole("STUDENT", "COMPANY", "ADMIN")

                .requestMatchers(HttpMethod.POST, "/api/jobs/**")
                .hasAnyRole("COMPANY", "ADMIN")

                .requestMatchers(HttpMethod.PUT, "/api/jobs/**")
                .hasAnyRole("COMPANY", "ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/api/jobs/**")
                .hasAnyRole("COMPANY", "ADMIN")

                // Applications
                .requestMatchers("/api/applications/**")
                .hasAnyRole("STUDENT", "COMPANY", "ADMIN")

                // Everything else requires login
                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }
}