package com.smart.contact.spconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsService getuserDetailsService() {
		
		 return new userServiceImpl(); 
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(); 
	}
	
	@Bean
	public DaoAuthenticationProvider DaoauthenticationProvider()
	{
		DaoAuthenticationProvider daop=new DaoAuthenticationProvider();
		daop.setUserDetailsService(getuserDetailsService());
		daop.setPasswordEncoder(passwordEncoder());
		
		return daop;
	}
	
	@Bean
	protected AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config)throws Exception{
		
		return config.getAuthenticationManager();
	}
	/*
	@Bean
    protected void  configure() throws Exception
    {

		  http.authorizeRequests().requestMatchers("/home/**").hasRole("ADMIN")
		  .requestMatchers("/user/**").hasRole("USER")
		  .requestMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
    }
	*/
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		  http.authorizeRequests()
		  .requestMatchers("/user/**").hasAuthority("USER")
		  .requestMatchers("/admin").hasAuthority("ADMIN")
		  .requestMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
		   http.authenticationProvider(DaoauthenticationProvider());
		  DefaultSecurityFilterChain build = http.build();
		  return build;
	}
	
}
