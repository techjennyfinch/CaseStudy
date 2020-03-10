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
 */

@Entity
public class UserRole {
	
	private int roleId;
	private String roleName;

	@OneToMany (targetEntity=WebUser.class, cascade = CascadeType.ALL)
	private Set <WebUser> webuser;
	
	
	
	//constructors
	
	public UserRole () {
		
	}



	
	protected UserRole(int roleId, String roleName, Set<WebUser> webuser) {
	
		this.roleId = roleId;
		this.roleName = roleName;
		this.webuser = webuser;
	}

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
	
	@OneToMany (targetEntity=WebUser.class, mappedBy= "userRole", cascade = CascadeType.ALL)
	public Set <WebUser> getWebuser() {
		return webuser;
	}


	/**
	 * @param webuser the webuser to set
	 */
	public void setWebuser(Set <WebUser> webuser) {
		this.webuser = webuser;
	}
	
	

}
