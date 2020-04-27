
package org.perscholas.ToolbeltCaseStudy.services;



/**
 * @author Jenny
 *
 */

public interface SecurityService {
	
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
	
	//this will allow auto login after registration.
	
	//also provides current logged in info

}
