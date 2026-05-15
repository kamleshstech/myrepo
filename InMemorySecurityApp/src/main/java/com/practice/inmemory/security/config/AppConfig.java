package com.practice.inmemory.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withUsername("ajay")
		.password("{noop}ajay@0001")
		.roles("user")
		.build();
		
		UserDetails admin = User.withUsername("suresh")
		.password("{noop}suresh@4562")
		.roles("admin")
		.build();
		
		return new InMemoryUserDetailsManager(user,admin);
				
	}
	
	@Bean
	public SecurityFilterChain secFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/home").hasAnyRole("user","admin")
				.requestMatchers("/inbox").hasRole("admin")
				.anyRequest().authenticated()
				).formLogin(form -> form
						.defaultSuccessUrl("/home",true)
				).logout(logout -> logout
						.logoutSuccessUrl("/login")
				);
		
		
		return http.build();
	}
	
	
}
