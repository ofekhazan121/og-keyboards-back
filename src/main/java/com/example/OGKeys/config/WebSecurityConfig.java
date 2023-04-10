package com.example.OGKeys.config;

import com.example.OGKeys.component.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        return http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/product/filter").permitAll()
                .requestMatchers("/product/getProduct").permitAll()
                .requestMatchers("/product/getByName").permitAll()
                .requestMatchers("/product/addproduct").permitAll()
                .requestMatchers("/users/signup").permitAll()
                .requestMatchers("/users/login").permitAll()
                .requestMatchers("/users/hello").hasAnyAuthority("ADMIN","WORKER")
                .requestMatchers("/order").permitAll()
                .requestMatchers("/order/get").permitAll()
                .requestMatchers("/order/getAll").permitAll()
                .and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public FilterRegistrationBean platformCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configAutenticacao = new CorsConfiguration();
        configAutenticacao.setAllowCredentials(true);
        configAutenticacao.addAllowedOriginPattern("*");
        configAutenticacao.addAllowedHeader("Authorization");
        configAutenticacao.addAllowedHeader("Content-Type");
        configAutenticacao.addAllowedHeader("Accept");
        configAutenticacao.addAllowedMethod("POST");
        configAutenticacao.addAllowedMethod("GET");
        configAutenticacao.addAllowedMethod("DELETE");
        configAutenticacao.addAllowedMethod("PUT");
        configAutenticacao.addAllowedMethod("OPTIONS");
        configAutenticacao.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", configAutenticacao);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(-110);
        return bean;
    }

    @Autowired
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

}