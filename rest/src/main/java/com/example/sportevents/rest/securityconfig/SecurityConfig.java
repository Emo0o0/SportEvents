//package com.example.sportevents.rest.securityconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        //httpSecurity.formLogin(Customizer.withDefaults());
//        httpSecurity.csrf().disable();
//        httpSecurity.headers().frameOptions().disable();
//        httpSecurity
//                .authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET,
//                        "/v3/api-docs",
//                        "/v3/api-docs/**",
//                        "/swagger-resources",
//                        "/swagger-resources/**",
//                        "/configuration/ui",
//                        "/configuration/security",
//                        "/swagger-ui/**",
//                        "/webjars/**",
//                        "/swagger-ui.html").permitAll()
//                .requestMatchers("/sportevent/create").permitAll()
//                .anyRequest().authenticated();
//        return httpSecurity.build();
//    }
//
//}