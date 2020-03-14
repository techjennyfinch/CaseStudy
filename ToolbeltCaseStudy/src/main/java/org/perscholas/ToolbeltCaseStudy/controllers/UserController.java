/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.perscholas.ToolbeltCaseStudy.services.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jenny
 * @param 
 *
 */
//@RestController
//@RequestMapping("users")
@Controller
public class UserController {
	
	@Autowired
	private WebUserService userService;
	
	@RequestMapping("/")
	public String viewHomePage () {
		return "index";
	}
	
	//other examples had more in the homepage mapping, but this page doesn't need anything.

	@GetMapping("/registration")
	public String registrationForm (Model model) {
		model.addAttribute("webUser", new WebUser());
		return "registration";
	}
	
	@PostMapping ("/registration")
	public String registrationSubmit (@ModelAttribute WebUser webUser) {
		userService.save(webUser);
		return "registrationcomplete";
	}

	

//	@RequestMapping("/")
//	public String viewHomePage(Model model) {
//		return "index";
//	}
	
	//page returns related to Login, Registration, and webuser
	
	
	
	//Format model.addAttribute ("thing", thing);
	//"thing" key , thing value
	
	
	//This would be for admin to make changes to role or change password.
//	@RequestMapping("/admin/allusers")
//	public String showAllUsers (Model model) {
//		List <WebUser> listAllUsers = WebUserService.listAll();
//		model.addAttribute("listAllUsers", listAllUsers);
	
//		return "allusers";
//		//return is the name of the html/jsp page
//	}
//	
	

}
