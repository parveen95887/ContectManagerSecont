package com.smart.contact.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {
	@RequestMapping("/index")
	public String userpage() {
		
		return "normal/dashbord";
	}
}
