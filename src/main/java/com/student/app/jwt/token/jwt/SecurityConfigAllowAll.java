//package com.student.app.jwt.token.jwt;
//
//import java.util.Arrays;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigAllowAll {
//
//	private static final Logger logger = LoggerFactory.getLogger(SecurityConfigAllowAll.class);
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
//		logger.info("........SecurityConfigAllowAllSecurityConfigAllowAll.......");
//
//		http.csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
//				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Use
//				.authorizeHttpRequests(auth -> auth.requestMatchers("/**").permitAll());
//		return http.build();
//	}
//
//	// You can also define other beans, like a PasswordEncoder
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	// To expose the AuthenticationManager as a bean, you can create a bean of type
//	// AuthenticationManager
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
//		return authenticationConfiguration.getAuthenticationManager();
//	}
//
//	// To allow cross origin request access
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "PATCH", "DELETE"));
//		configuration.setAllowCredentials(true);
//		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//		configuration.setMaxAge((long) 10);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//}