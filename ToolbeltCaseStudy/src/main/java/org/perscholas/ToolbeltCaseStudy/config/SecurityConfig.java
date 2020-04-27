package org.perscholas.ToolbeltCaseStudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//Handles Security Configuration. Pages and requests MUST have some sort of permissions to work/load.

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("userDetailsImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	
	//left some lines commented out for quick changes. Handle this section with care.
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()

				.antMatchers("/", "/home", "/index", "/about", "/registration", "/registration-complete",
						"/processregistration", "/processlogin", "/loginpage", "access_denied")
				.permitAll()

				.antMatchers("/trailer", "/edit_trailer", "/newtrailer", "/save", "/tool", "/edit_tool",
						"/delete_tool/", "/new_tool", "/save_tool", "/fulltrailerinventory", "/inventory",
						"/delete_inventory_item/", "edit_inventory_item/", "/save_item", "/load_trailer/",
						"/trailerinventory", "/build")
				.hasAnyRole("ADMIN", "MANAGER")

				.anyRequest().authenticated()

				.and()

				// .csrf().disable()
				// this is cross site request forgery protection
				.formLogin().loginPage("/loginpage")
				// .failureUrl("/loginpage?error=true")
				.loginProcessingUrl("/processlogin").successHandler(customAuthenticationSuccessHandler)

				// .defaultSuccessUrl("/")
				// .usernameParameter("userName")
				// .passwordParameter("password")
				.permitAll().and()

				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// .logoutUrl("/logout")
				.logoutSuccessUrl("/about").permitAll()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/")
//				.and().rememberMe()
//				.tokenValiditySeconds(60*60)
				.and().exceptionHandling().accessDeniedPage("/access-denied");

	}

	// Should allow access to other resource pages for style sheets, scripts, and images.
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/styles/**", "/scripts/**", "/css/**", "/js/**",
				"/images/**");
	}

	@Bean
	public AuthenticationManager customAuthenicationManager() throws Exception {
		return authenticationManager();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
