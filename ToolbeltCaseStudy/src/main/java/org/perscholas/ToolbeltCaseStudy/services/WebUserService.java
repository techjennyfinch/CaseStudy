
package org.perscholas.ToolbeltCaseStudy.services;

import java.util.List;

import org.perscholas.ToolbeltCaseStudy.models.UserRole;
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
@Service
public class WebUserService {
	
	//one example has this implementing userservice and class would be webuserserviceimpl
	
	@Autowired
	private WebUserRepository userRepo;
	
	@Autowired 
	private RoleRepository roleRepo;
	
	@Autowired 
	private BCryptPasswordEncoder encode;
	
	
	//These are the crud functions
	
	public List<WebUser> listAll() {
		return userRepo.findAll();
	}
	
	public void save (WebUser webUser) {
		userRepo.save(webUser);
	}
	
	
	// created option in repository will have to test to see if it works.
	public WebUser get (String userName) {
		return userRepo.findByUserName(userName);
	}
	
	
	public void delete (String userName) {
		userRepo.deleteByUserName(userName);
	}

	public void regSave (WebUser webUser) {
		String pwd = webUser.getPassword();
		String encryptPwd = encode.encode(pwd);
		webUser.setPassword(encryptPwd);
		//sets new encrypted password
		UserRole r = roleRepo.getOne(5);
		webUser.setUserRole(r);
		
		userRepo.save(webUser);
		
	}

}
