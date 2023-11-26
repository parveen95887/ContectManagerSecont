package com.smart.contact.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.contact.Entity.contact;
import com.smart.contact.Entity.user;
import com.smart.contact.Repository.userRepository;
import com.smart.contact.helper.massage;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userRepository ur;
	//pre executed method for all method
	
	  @ModelAttribute public user abc(Model m,Principal p) { String name =
	  p.getName(); System.out.println(name);
	  
	  user userByUserName = ur.getUserByUserName(name);
	  System.out.println(userByUserName); m.addAttribute("user",userByUserName);
	  return userByUserName; }
	 
	
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
	
	@RequestMapping( path ="/process-contect-form",method = RequestMethod.POST)
	public String processContactForm(Model m,@Valid @ModelAttribute contact cont,@RequestParam("image") MultipartFile file,
			BindingResult bres,HttpSession session,Principal pr) throws Exception {
		System.out.println("A");
		
		//System.out.println(file.getOriginalFilename());
		   String name = pr.getName();
		   System.out.println("B");
		   
		   try{
		   if(bres.hasErrors()){
			   System.out.println("Error in fields "+bres.toString());
			   session.setAttribute("massage", new massage("alert-success", "something went rong"));
			   return "normal/add_contectform";
		    }
		   
		   System.out.println("Aone");
		   user userByUserName = ur.getUserByUserName(name);
		   System.out.println("Mohali "+userByUserName.getName());
		  
		   if(file.isEmpty()) {
			   System.out.println("file is empty wala part");
			   //if file is empty the shwo some massage
		   }
			   //uplode file 
			   //get file name by file object and set image into contact
			   System.out.println("original file name "+file.getOriginalFilename());
			   cont.setImg(file.getOriginalFilename());
			   System.out.println("Bone");
			   //find file uplode path 
			   File file2 = new ClassPathResource("static/img").getFile();
			   //find file ulodeed path
			   System.out.println("Cone");
			   System.out.println("file2 "+file2);
			   Path path = Paths.get(file2.getAbsolutePath()+File.separator+file.getOriginalFilename());
			   //uplode file 
			   System.out.println("path "+path);
			   Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			   
		   
		   cont.setUser(userByUserName);
		   userByUserName.getContact().add(cont);
		   ur.save(userByUserName);
		   session.setAttribute("massage", new massage("alert-success", "new contect add successfully"));
	    System.out.println(cont);
		   }catch(Exception e){
			   
			   session.setAttribute("massage", new massage("alert-danger", "something went rong "));
		   }
	   
	     return "normal/add_contectform";
	}
}



	

