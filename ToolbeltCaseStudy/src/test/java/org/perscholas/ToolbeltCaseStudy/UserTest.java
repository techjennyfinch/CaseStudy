/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.perscholas.ToolbeltCaseStudy.services.WebUserServiceImpl;

/**
 * @author Jenny
 *
 */
class UserTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	//This test checks 
		@Test
		public void findByUsernameTest() {
			WebUserServiceImpl userService = new WebUserServiceImpl();
			WebUser test = new WebUser ("bob", "Bob", "Builder", "bob@build.com", "password");
			userService.save(test);
			
			WebUser validTestUser  = userService.findByUsername("bob");
		
		//	WebUser expectedUser = test;
			assertEquals(test,validTestUser);
		}


}