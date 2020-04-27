/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.services;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.perscholas.ToolbeltCaseStudy.models.UserRole;
import org.perscholas.ToolbeltCaseStudy.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jenny
 *
 */
public class RoleService {
	
	
	@Autowired 
	private RoleRepository roleRepo;
	
	@Autowired 
	private EntityManager entityManager;
	
	public UserRole findRoleByName (String theRoleName) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//now retrieve/read from database using name
		
		Query<UserRole> theQuery = currentSession.createQuery("from UserRole where name=:roleName", UserRole.class);
		theQuery.setParameter("roleName", theRoleName);
		
		//would think this could also be
	//	UserRole userRole = roleRepo.findByRoleName(theRoleName);
		
		UserRole userRole = null;
		
		try {
			userRole = theQuery.getSingleResult();
		}catch(Exception e) {
			userRole = null;
		}
		
		return userRole;
		
	}

}
