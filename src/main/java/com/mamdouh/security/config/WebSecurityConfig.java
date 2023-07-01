package com.mamdouh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mamdouh.security.realsecurity.ApplicationUserPermission;
import com.mamdouh.security.realsecurity.StudentAndAdmin;
import com.mamdouh.user.AppUserRole;
import com.mamdouh.user.ApplicationUserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig{
	public ApplicationUserService applicationUserService;
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	
   
	
	  @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//	    	http.csrf()//by diabling the csrf we can make a post and delete requests from postman
//	    	.disable().
//	    	authorizeHttpRequests()
//	    	.requestMatchers("/","/index.html").permitAll().
//	    	anyRequest().
//	    	authenticated().
//	    	and().
//	    	formLogin().loginPage("login.html").permitAll().defaultSuccessUrl("/index",true).passwordParameter("password").usernameParameter("email");
//
		     http.csrf().disable().authorizeHttpRequests().requestMatchers("/","/index").permitAll().anyRequest().authenticated().and().httpBasic();
	    	return http.build();
	    }
	  
	  @Bean
	    AuthenticationManager authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
	        return  builder.authenticationProvider(daoAuthenticationProvider()).build();//there is a possibility that there is something wrong with this line
	    }

	  @Bean
	  public DaoAuthenticationProvider daoAuthenticationProvider() {
		  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		  provider.setPasswordEncoder(bCryptPasswordEncoder);
		  provider.setUserDetailsService(applicationUserService);
		  return provider;
	  }
}
