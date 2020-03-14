package org.perscholas.ToolbeltCaseStudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new PasswordEncoder(){
			
			public String encode(CharSequence rawPassword) {
				String newPassword = bCryptPasswordEncoder.encode(rawPassword);
				return newPassword;
			}
			
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				if(bCryptPasswordEncoder.matches(rawPassword, encodedPassword)) {
					return true;
				}else
					return false;
			}
		});
		
	}
	
	public void configure (HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/edit_user").hasRole("1")
		.antMatchers("/management/**").hasRole("1")
		.antMatchers("/profile/**").hasAnyRole("ADMIN", "USER", "1", "3", "5")
		.antMatchers("/registration").permitAll()
		.antMatchers("/loginpage/").permitAll()
		.antMatchers("/").permitAll()
		.anyRequest().permitAll()
		.and()
		
		.csrf().disable()
		.formLogin()
		.loginPage("/loginpage/")
		.failureUrl("/loginpage?error=true")
		.defaultSuccessUrl("/")
		.usernameParameter("userName")
		.passwordParameter("password")
		.and()
		
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
			
	}

	@Override 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
}
