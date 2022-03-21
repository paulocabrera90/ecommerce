package com.infosl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.infosl.ecommerce.model.UsuarioTipo;

@Configuration
@EnableWebSecurity
public class SpringBootSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(getEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/administrador/**").hasRole(UsuarioTipo.ADMIN.toString())
		.antMatchers("/productos/**").hasRole(UsuarioTipo.ADMIN.toString())
		.and().formLogin().loginPage("/usuario/login")
		.permitAll().defaultSuccessUrl("/usuario/validate");
	}
	
	
	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
