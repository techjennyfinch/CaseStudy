
package org.perscholas.ToolbeltCaseStudy.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.perscholas.ToolbeltCaseStudy.repositories.RoleRepository;
import org.perscholas.ToolbeltCaseStudy.repositories.WebUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Jenny
 *
 */
//The class formerly known As WebUserService.  Had to change because an interface webUserService was required for security tools.

@Service
public class WebUserServiceImpl implements WebUserService {

	@Autowired
	private WebUserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder encode;

	// These are the crud functions

	public List<WebUser> listAll() {
		return userRepo.findAll();
	}

//These two are the same, but one is from the WebUserService interface and the other from the repository.

	public WebUser findUserbyUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	@Override
	public WebUser findByUsername(String username) {
		return userRepo.findByUserName(username);
	}

	public WebUser get(String userName) {
		return userRepo.findByUserName(userName);
	}

	public void delete(String userName) {
		userRepo.deleteByUserName(userName);
	}

	// This is for admin use. when changing user passwords or roles.
	@Override
	public void save(WebUser webuser) {

		webuser.setPassword(encode.encode(webuser.getPassword()));
		webuser.setUserRoles(new HashSet<>(roleRepo.findAll()));
		userRepo.save(webuser);

	}

	// This is the save method for saving user from the registration process. Sets
	// role to User(most restrictive)
	public void regSave(WebUser webUser) {

//		// assigning details to the user object.	
		System.out.println("beginning registration process.. in regSave");
		webUser.setPassword(encode.encode(webUser.getPassword()));
		// This assigns the ROLE of user to all users when registering.
		webUser.setUserRoles(Arrays.asList(roleRepo.findByRoleName("ROLE_USER")));
		System.out.println("before saving");
		userRepo.save(webUser);
	}

}
