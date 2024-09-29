package com.fsd2425.Restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class springconfig {
	
	@Bean
    public PasswordEncoder selectEncoder() {
        return new BCryptPasswordEncoder();
 }
 
@Bean
	public UserDetailsService createUsers() {
		UserDetails user1 = User.builder()
			.username("karthik")
			.password(selectEncoder().encode("123@"))
			.roles("USER")
			.build();
		UserDetails user2 = User.builder()
	 			.username("kiran")
	 			.password(selectEncoder().encode("1234@"))
	 			.roles("USER")
	 			.build();
		UserDetails admin = User.builder()
			.username("manvith")
			.password(selectEncoder().encode("123@manvith"))
			.roles("ADMIN", "USER")
			.build();
		return new InMemoryUserDetailsManager(user1, user2, admin);
	}

	@Bean
	public SecurityFilterChain createRoles(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) ->
				authorizeHttpRequests
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/user").hasRole("USER")
					.requestMatchers("/error/**").permitAll()
					.requestMatchers("/").permitAll()
			)
			.formLogin(Customizer.withDefaults())
			.exceptionHandling((exception) ->
			exception.accessDeniedPage("/error/access-denied"));
		return http.build();
	}


}
