package org.perscholas.ToolbeltCaseStudy.controllers;

import org.perscholas.ToolbeltCaseStudy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

	
	@Autowired
	private RoleRepository roleRepo;
	
	//@GetMapping("management")
}
