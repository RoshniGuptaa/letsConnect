package com.chat.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {
    
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       return  http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()).addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request)
                    {
                    	CorsConfiguration cfg=new CorsConfiguration();
                    	cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000/"));
                    	cfg.setAllowedMethods(Collections.singletonList("*"));
                    	cfg.setAllowCredentials(true);
                    	cfg.setAllowedHeaders(Collections.singletonList("*"));
                    	cfg.setExposedHeaders(Arrays.asList("Authorization"));
                    	cfg.setMaxAge(3600L);
                        return cfg;
                    }

                })).formLogin(login -> login
                        .permitAll()
                        .loginPage("/login") // Specify your custom login page URL
                        .loginProcessingUrl("/authenticate") // Specify your custom login processing URL
                        .defaultSuccessUrl("/success") // Specify the default success URL
                        .failureUrl("/login?error=true")) // Specify the failure URL)
                        .httpBasic().and().build();
//		return http.build();
	}
	//ByCrypt user password -using cryptography hash password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
