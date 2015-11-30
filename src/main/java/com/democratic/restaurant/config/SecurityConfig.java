package com.democratic.restaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;





/**
 * @author Ricardo Machado
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("user", "ADMIN").and()
		.withUser("ricardo").password("ricardo").roles("user").and()
		.withUser("ricardo1").password("ricardo").roles("user").and()
		.withUser("ricardo2").password("ricardo").roles("user").and()
		.withUser("ricardo3").password("ricardo").roles("user").and()
		.withUser("ricardo4").password("ricardo").roles("user").and()
		.withUser("ricardo5").password("ricardo").roles("user").and()
		.withUser("ricardo6").password("ricardo").roles("user").and()
		.withUser("ricardo7").password("ricardo").roles("user").and()
		.withUser("ricardo8").password("ricardo").roles("user").and()
		.withUser("ricardo9").password("ricardo").roles("user").and()
		.withUser("ricardo10").password("ricardo").roles("user").and()
		.withUser("ricardo11").password("ricardo").roles("user").and()
		.withUser("ricardo12").password("ricardo").roles("user").and()
		.withUser("ricardo13").password("ricardo").roles("user").and()
		.withUser("ricardo14").password("ricardo").roles("user").and();
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/resources/**")
			.permitAll()
			.anyRequest().authenticated().and()
			.formLogin()
			.loginPage("/login")
			.permitAll().and()
			.logout().permitAll();
	}
}