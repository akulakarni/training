package com.prokarma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailService userDetailservice;
	
	protected void  configure(AuthenticationManagerBuilder auth) throws Exception{
		
	}
/*	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication().withUser("username").password("password").roles("user");
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}*/
}
