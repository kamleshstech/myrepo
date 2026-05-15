package com.practice.db.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests(auth -> auth
				.requestMatchers("/register","/common","/save","/login").permitAll()
				.requestMatchers("/admin").hasAuthority("admin")
				.requestMatchers("/employee").hasAuthority("manager")
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/home",true)
					.permitAll()
			)
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
					.permitAll()
			)
			.exceptionHandling()
			.accessDeniedPage("/denied");
		
		return http.build();
	}
	
	
	
	
}//class
