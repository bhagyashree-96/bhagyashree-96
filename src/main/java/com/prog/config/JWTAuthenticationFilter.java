//package com.prog.config;
//
//import java.io.IOException;
//import java.security.AlgorithmConstraints;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.servlet.FilterChain;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.prog.entity.UserDtls;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//
//
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private SecurityConstants cc;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//
//        setFilterProcessesUrl("/api/services/controller/user/login"); 
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse res) throws AuthenticationException {
//        try {
//            User creds = new ObjectMapper()
//                    .readValue(req.getInputStream(), User.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            creds.getName(),
//                            creds.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest req,
//                                            HttpServletResponse res,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException {
//    	
////        String token = JWT.create()
////                .withSubject(((User) auth.getPrincipal()).getName())
////                .withExpiresAt(new Date(System.currentTimeMillis() + cc.EXPIRATION_TIME))
////                .sign(Algorithm.HMAC512(cc.SECRET.getBytes()));
//
//    	
//    	// Assuming cc.EXPIRATION_TIME and cc.SECRET are defined correctly
//    	String token = Jwts.builder()
//    	    .setSubject(((User) auth.getPrincipal()).getName())
//    	    .setExpiration(new Date(System.currentTimeMillis() + cc.EXPIRATION_TIME))
//    	    .signWith(SignatureAlgorithm.HS512, cc.SECRET.getBytes())
//    	    .compact();
//
//    	
//    	
//        String body = ((User) auth.getPrincipal()).getName() + " " + token;
//
//        res.getWriter().write(body);
//        res.getWriter().flush();
//    }
//    	
//    	}
//
//
