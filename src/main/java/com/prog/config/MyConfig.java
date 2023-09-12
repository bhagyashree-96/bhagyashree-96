package com.prog.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class MyConfig  {
	
	@Bean 
	public UserDetailsService getUserDetailsService()
	{
		return new CustomUserDtlsService();
	}
	
	@Bean
	public BCryptPasswordEncoder  getPassword() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoProvider() {//getdaoauthprovider
		 
		 DaoAuthenticationProvider dao=new DaoAuthenticationProvider();//dao=daoauthonticationprovidr
		 dao.setUserDetailsService(getUserDetailsService());
		 dao.setPasswordEncoder(getPassword());
		 return dao; 
	  }
	

		/*
		 * @Bean protected void configure(AuthenticationManagerBuilder auth)throws
		 * Exception{ auth.authenticationProvider(daoProvider()); }
		 * 
		 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.
		authorizeHttpRequests()
		.requestMatchers("/user/**")
		.hasRole("USER")
		.requestMatchers("/**")
		.permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/dologin").defaultSuccessUrl("/user/home")
		.and()
		.csrf()
		.disable();
		
		http.authenticationProvider(daoProvider());
		return http.build();
	}
	
	
	

	
	/*
	 * @Override protected void configure(HttpSecurity http)throws Exception{
	 * http.authorizeRequests().antMatchers("/user/**").hasRole("USER").antMatchers(
	 * "/**").permitAll().and().formLogin().and().csrf().disable(); }
	 */
	
	
	
	
	
	
	

}