/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;

/**
 * @author Jenny
 *
 */
public interface WebUserService {
	
	void save(WebUser webuser);
	
	WebUser findByUsername(String username);

}
