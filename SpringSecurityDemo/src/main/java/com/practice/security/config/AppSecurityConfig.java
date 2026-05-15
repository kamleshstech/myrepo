package com.practice.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
			authorize -> authorize.requestMatchers(HttpMethod.DELETE, "/invoice/deleteInv/{invNum}").hasAnyRole("ADMIN")
			.requestMatchers("/invoice/**").permitAll()
				).httpBasic(Customizer.withDefaults());
		http.csrf(CsrfConfigurer::disable);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.builder()
				.username("allen")
				.password(passwordEncoder().encode("allen@123"))
				.roles("ADMIN").build();
		
		UserDetails user = User.builder()
				.username("guest")
				.password(passwordEncoder().encode("guest"))
				.roles("GUEST").build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
}
