package com.smart.contact.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.contact.Entity.user;
import com.smart.contact.Repository.userRepository;
import com.smart.contact.helper.massage;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@Controller
public class HomeController {
            
      @Autowired
     private userRepository ur;
      @Autowired
      private  BCryptPasswordEncoder passwordEncoder;
      
		/*
		 * public HomeController(PasswordEncoder passwordEncoder) { this.passwordEncoder
		 * = passwordEncoder; }
		 */
      //@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/")
	public String home(Model m) {
		m.addAttribute("title", "welcome to home page");
		 return "home";
	}
      //@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "welcome to about page");
		return "about";
	}
    
     // @PreAuthorize("hasRole('ADMIN')")  
	@RequestMapping("/reg")
	public String registration(Model m,HttpSession session) {
		m.addAttribute("title","registration form");
		m.addAttribute("user",new user());	 
		return "registration";
	}
      //@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("title","login page");
		return "login";
	}
	
     
	@RequestMapping( path = "/do-register",method = RequestMethod.POST )
	public String  doRegistration(Model m , @Valid @ModelAttribute user u,BindingResult bresult,@RequestParam(value="check",defaultValue="false") boolean check 
			,HttpSession session){
		
		try {
			if(!check){
				
				throw new Exception("you are not aggreed term and conditions");
			}
			if(bresult.hasErrors()){
				System.out.println("Error"+bresult.toString());
				m.addAttribute("user",u);
					return "registration";
			}
		System.out.println("user"+u);
		//System.out.println("check"+check);
		u.setEnabaled(true);
		u.setImgurl("abc");
		System.out.println("GET PASSWORD IS "+u.getPass());
		u.setPass(passwordEncoder.encode(u.getPass()));
		System.out.println("After encoded password"+u.getPass());
		u.setRole("USER");
		m.addAttribute("user",u);
		user save = ur.save(u);
		//System.out.println("Result"+save);
		session.setAttribute("massage", new massage("alert-success","Successfully Register"));
		}catch(Exception e)
		{ 
			m.addAttribute("user",u);
			session.setAttribute("massage", new massage("alert-danger","somthing went rong"+e.getMessage()));
			e.printStackTrace();
		    return "registration";
		}
		return "registration";	
	}
}
