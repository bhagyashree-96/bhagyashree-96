//package com.prog.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.data.convert.ReflectionEntityInstantiator;
//
//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//	 private static final String[] allowed= {"/","/register","/resendVerifyToken","/verifyRegistration"};
//	
//	@Autowired
//	private SecurityConstants cc;
//	
//	@Autowired
//	private TokenProvider tokenProvider;
//
//
//	 private CustomUserDtlsService userDetailsService;
//	    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	    public WebSecurity(CustomUserDtlsService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//	        this.userDetailsService = userService;
//	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	    }
//
//	    @Override
//	    @Order(Ordered.HIGHEST_PRECEDENCE)
//	    @Lazy
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests()
//	                .antMatchers("/user/**").authenticated()
//	                .anyRequest().permitAll()
//	            .and()
//	            .formLogin()
//	                .loginPage("/login")
//	                .permitAll()
//	            .and()
//	            .logout()
//	                .permitAll();
//	    }
//
//	    @Override
//	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//	    }
//
//	    @Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//	        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//	        source.registerCorsConfiguration("/**", corsConfiguration);
//
//	        return source;
//	    }
//
//		public static String[] getAllowed() {
//			return allowed;
//		}
//
//		public SecurityConstants getCc() {
//			return cc;
//		}
//
//		public void setCc(SecurityConstants cc) {
//			this.cc = cc;
//		}
//
//		public TokenProvider getTokenProvider() {
//			return tokenProvider;
//		}
//
//		public void setTokenProvider(TokenProvider tokenProvider) {
//			this.tokenProvider = tokenProvider;
//		}
//}
