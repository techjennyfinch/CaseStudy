/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;


import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 * @author Jenny
 * This Class is a place to identify roles 
 * Relationship is one user role to many webusers
 */

@Entity
public class UserRole {
	
	private int roleId;
	private String roleName;

	
	//removing to test 3/13
	
	private Set <WebUser> webUser;
	
	
	
	//constructors
	
	public UserRole () {
		
	}



	
public UserRole(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}




//	protected UserRole(int roleId, String roleName, Set<WebUser> webUser) {
//	
//		this.roleId = roleId;
//		this.roleName = roleName;
//		this.webUser = webUser;
//	}

//getters and setters

	/**
	 * @return the roleId
	 */
	@Id
	@Column(name = "roleId", nullable = false, columnDefinition="int (2) default 5")
	public int getRoleId() {
		return roleId;
	}


	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	/**
	 * @return the roleName
	 */
	@Basic
	@Column(name = "roleName", nullable = false, length=30)
	public String getRoleName() {
		return roleName;
	}


	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	/**
	 * @return the webuser
	 */
	@OneToMany (mappedBy="userRole")
	public Set<WebUser> getWebUser() {
		return webUser;
	}




	public void setWebUser(Set<WebUser> webUser) {
		this.webUser = webUser;
	}


	
	

}
