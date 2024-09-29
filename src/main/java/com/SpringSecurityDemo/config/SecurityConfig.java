package com.SpringSecurityDemo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SecurityConfig {

	@Bean
	public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/users/add").hasRole("AdminMinnu")
		.requestMatchers("/users/**").hasRole("UserDolly")
		.and()
		.httpBasic();
		return http.build();
	}
	@Bean
    public PasswordEncoder pEn() {
        return new BCryptPasswordEncoder();
        
    }
	@Bean
	public UserDetailsService uDs(PasswordEncoder pEn) {
		UserDetails u = User.builder()
		.username("dolly")
		.password(pEn.encode("12221"))
		.roles("UserDolly")
		.build();
		
	UserDetails D = User.builder()
			.username("Minnu")
			.password(pEn.encode("12345"))
			.roles("AdminMinnu","UserDolly")
			.build();
	
	return new InMemoryUserDetailsManager(D,u);
	}
	
}
