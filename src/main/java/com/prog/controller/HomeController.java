package com.prog.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.prog.entity.UserDtls;
import com.prog.repository.PropertyRepository;
import com.prog.repository.UserRepository;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class HomeController {
	
	@Autowired
	private UserRepository repo;
	
   @Autowired
	private PropertyRepository pprepo;

	@GetMapping("/home")
	public String home(Principal p,Model m) {
		
		String em=p.getName();
	UserDtls u=	repo.findByEmail(em);
		m.addAttribute("fullName",u.getFullname());
		m.addAttribute("address",u.getAddress());
		m.addAttribute("em",u.getEmail());
		return"property";
	}
	
//	@GetMapping("/view")
//	 public String all(Principal p,Model m) {
//
//		String em=p.getName();
//	Property u=	pprepo.findByName(em);
//		m.addAttribute("name",u.getName());
//		m.addAttribute("picture",u.getPicture());
//		m.addAttribute("location",u.getLocation());
//		m.addAttribute("price",u.getPrice());
//		m.addAttribute("description",u.getDescription());
//		return"viewproperty";
//	    }
	
	@GetMapping("/view")
	public String viewAll(Model model) {
	    model.addAttribute("users", pprepo.findAll());
	    return "viewproperty";
	}
	@GetMapping("/UpdateProperty")
	public String updateProperty(Model model) {
	    model.addAttribute("users", pprepo.findAll());
	    return "UpdateProperty";
	}
	
	
}
