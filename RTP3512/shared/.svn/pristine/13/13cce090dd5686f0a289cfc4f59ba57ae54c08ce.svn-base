package com.st.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.st.spring.boot.auth.UserLoginSuccessHandler;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserLoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
    	.antMatchers("/style/**", "/script/**", "/img/**")
    	.permitAll()
    	.anyRequest()
    	.fullyAuthenticated()
    		.and()
    	.formLogin()
    	.loginPage("/login") // do not change this
    	.successHandler(loginSuccessHandler)
    	.failureUrl("/loginFailed")
    	.usernameParameter("userName") // this is the 'name' attribute in the user name <input> field in UI 
    	.passwordParameter("password") // this is the 'password' attribute in the password <input> field in UI
    	.permitAll()
    		.and()
    	.logout()
    	.logoutUrl("/logout") // do not change this
    	.logoutSuccessUrl("/logoutSuccess")
    	.permitAll();

		http.csrf().disable();
	}

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService)
      .passwordEncoder(new BCryptPasswordEncoder());
    }
	
	
	
	
	
	
	
	
	
}
