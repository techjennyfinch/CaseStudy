/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.controllers;

import java.util.logging.Logger;


import org.perscholas.ToolbeltCaseStudy.models.WebUser;

import org.perscholas.ToolbeltCaseStudy.services.WebUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jenny
 *
 */

@Controller
//@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private WebUserServiceImpl userService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/registration")
	public String RegistrationForm(Model model) {

		model.addAttribute("webUser", new WebUser());

		return "registration";
	}

	@PostMapping("/processregistration")
	public String processegistration(@ModelAttribute("webUser") WebUser webUser, BindingResult theBindingResult,
			Model theModel) {

		String userName = webUser.getUserName();
		logger.info("Processing registration form for: " + userName);
		System.out.println("processing reg form.");
		// form validation
		if (theBindingResult.hasErrors()) {
			return "registration";
		}

		// check the database if user already exists
		System.out.println("checking for existing username.");
		WebUser existing = userService.findUserbyUserName(userName);
		if (existing != null) {
			theModel.addAttribute("webUser", new WebUser());
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			return "registration";
		}

		// create user account
		userService.regSave(webUser);

		logger.info("Successfully created user: " + userName);

		return "registration-complete";
	}


}
