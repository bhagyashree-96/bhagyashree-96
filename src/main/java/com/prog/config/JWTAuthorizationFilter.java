//package com.prog.config;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import io.jsonwebtoken.Jwts;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.xml.crypto.AlgorithmMethod;
//
//
//public class JWTAuthorizationFilter  extends BasicAuthenticationFilter{
//
//	
//	String user=null;
//	
//	@Autowired
//	private SecurityConstants cc;
//
//	 public JWTAuthorizationFilter(AuthenticationManager authManager) {
//	        super(authManager);
//	    }
//
//	    @Override
//	    protected void doFilterInternal(HttpServletRequest req,
//	                                    HttpServletResponse res,
//	                                    FilterChain chain) throws IOException, ServletException {
//	        String header = req.getHeader(cc.HEADER_STRING);
//
//	        if (header == null || !header.startsWith(cc.TOKEN_PREFIX)) {
//	            chain.doFilter(req, res);
//	            return;
//	        }
//
//	        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        chain.doFilter(req, res);
//	    }
//
//	    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
//	    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//	        String token = request.getHeader(cc.HEADER_STRING);
//
//	        if (token != null) {
//	            // parse the token.
////	            String user = JWT.require(Algorithm.HMAC512(cc.SECRET.getBytes()))
////	                    .build()
////	                    .verify(token.replace(cc.TOKEN_PREFIX, ""))
////	                    .getSubject();
//	        	
//	        	try {
//	        	    user = Jwts.parser()
//	        	            .setSigningKey(cc.SECRET.getBytes())
//	        	            .parseClaimsJws(token.replace(cc.TOKEN_PREFIX, ""))
//	        	            .getBody()
//	        	            .getSubject();
//	        	    // Do something with the extracted 'user' value
//	        	} catch (Exception e) {
//	        	    // Handle the exception (e.g., log it or return an error response)
//	        	}
//
//
//	            if (user != null) {
//	                
//	                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//	            }
//
//	            return null;
//	        }
//
//	        return null;
//}
//}
