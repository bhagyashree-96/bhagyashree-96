package com.prog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.prog.entity.Property;
import com.prog.entity.UserDtls;
import com.prog.repository.PropertyRepository;
import com.prog.repository.UserRepository;
import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	
    @Autowired
	private UserRepository repo;
    
    @Autowired
    private BCryptPasswordEncoder bp;
    
    @Autowired
    private PropertyRepository prepo;
	
	
	@GetMapping("/")
	public String home() {
		return"index";
	}
	
	@GetMapping("login")
	public String login() {
		return"login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "index";
		
	}
	@PostMapping("/register")	
public String register(@ModelAttribute UserDtls u,HttpSession session) {
	System.out.println(u);
	u.setPassword(bp.encode(u.getPassword()));
	
	u.setRole("ROLE_USER");
	repo.save(u);
	session.setAttribute("message", "User Register Successfully");
	
   return "redirect:/";
}
@PostMapping("/addnewproperty")	
public String addNewProperty(@ModelAttribute Property p,HttpSession session) {
	System.out.println(p);
	p.setName(p.getName());
	p.setPicture(p.getPicture());
	p.setLandmark(p.getLandmark());
	p.setPrice(p.getPrice());
	p.setDescription(p.getDescription());
	prepo.save(p);
	session.setAttribute("message", "New Property Added Successfully");
	
  return "redirect:/";
}




}
