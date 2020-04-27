/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.perscholas.ToolbeltCaseStudy.services.WebUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author Jenny
 *
 */
// This Handler works with the Security Configuration to handle login.

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private WebUserServiceImpl userService;
	

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("\n\nIn customauthenticationHandler \n\n");
		
		String userName = authentication.getName();
		
		System.out.println("userName= " + userName);
		
		WebUser theUser = userService.findUserbyUserName(userName);
		
		//now place in the session
		
		HttpSession session = request.getSession();
		session.setAttribute("webUser", theUser);
		
		//forward to homepage.. maybe this should go to success page?
		
		response.sendRedirect(request.getContextPath()+ "/");
				
	}

}
