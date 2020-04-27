/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import java.util.HashSet;
import java.util.Set;

import org.perscholas.ToolbeltCaseStudy.models.UserRole;
import org.perscholas.ToolbeltCaseStudy.models.WebUser;
import org.perscholas.ToolbeltCaseStudy.repositories.WebUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jenny
 *
 */

//This is required for Security.  Most User tools are handled by WebUserServiceImpl.

@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	private WebUserRepository userRepo;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		WebUser webuser = userRepo.findByUserName(username);
		if (webuser == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (UserRole userrole : webuser.getUserRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userrole.getRoleName()));
		}

		return new org.springframework.security.core.userdetails.User(webuser.getUserName(), webuser.getPassword(),
				grantedAuthorities);
	}

}
