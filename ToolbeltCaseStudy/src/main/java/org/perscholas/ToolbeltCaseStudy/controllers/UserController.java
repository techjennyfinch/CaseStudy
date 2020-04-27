/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jenny
 * @param
 *
 */
//Controls general pages, and login

@Controller
public class UserController {

	@RequestMapping(value = { "/", "", "home", "/index" })
	public String viewHomePage() {
		return "index";
	}

	@RequestMapping("/about")
	public String viewAbout() {
		return "about";
	}

	@RequestMapping("/access-denied")
	public String accessdenied() {
		return "access-denied";
	}

	// no post mapping for login page it is handled by spring security.

	@GetMapping("/loginpage")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and/or password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		return "loginpage";
	}

}
