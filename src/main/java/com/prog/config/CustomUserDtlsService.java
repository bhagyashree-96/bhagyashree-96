package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prog.entity.UserDtls;
import com.prog.repository.UserRepository;
@Service
public class CustomUserDtlsService implements UserDetailsService  {
@Autowired
 private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
		
		try {
			UserDtls u=repo.findByEmail(em);
			if(u==null) {
				throw new UsernameNotFoundException("No User");
			}
			else {
				return new CustomUserDtls(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		return null;
	}

}
