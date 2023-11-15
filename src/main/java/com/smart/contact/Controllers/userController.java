package com.smart.contact.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.contact.Entity.contact;
import com.smart.contact.Entity.user;
import com.smart.contact.Repository.userRepository;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userRepository ur;
	//pre executed method for all method
	@ModelAttribute
	public user abc(Model m,Principal p) {
		String name = p.getName();
		System.out.println(name);
		
		user userByUserName = ur.getUserByUserName(name);
		System.out.println(userByUserName);
		m.addAttribute("user",userByUserName);
		return userByUserName;	
	}
	
	@RequestMapping("/index")
	public String userpage(Model m,Principal p) {
		String name = p.getName();
		System.out.println(name);
		
		user userByUserName = ur.getUserByUserName(name);
		System.out.println(userByUserName);
		m.addAttribute("user",userByUserName);
		return "normal/dashbord";
	}
	
	@RequestMapping("/addContectform")
	public String showcontects(Model m) {
		m.addAttribute("title", "Add-Contect-Form");
		m.addAttribute("contact",new contact());
		return "normal/add_contectform";
	}
}
