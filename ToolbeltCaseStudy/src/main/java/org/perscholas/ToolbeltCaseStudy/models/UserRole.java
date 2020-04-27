/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Jenny This Class is a place to identify roles for security.
 */

@Entity
@Table(name = "userrole")
public class UserRole {

	private int roleId;
	private String roleName;

	private Set<WebUser> webUser;

//Constructors

	public UserRole() {

	}

	protected UserRole(int roleId, String roleName, Set<WebUser> webUser) {

		this.roleId = roleId;
		this.roleName = roleName;
		this.webUser = webUser;
	}

	// Getters and Setters

	public UserRole(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	@Id
	@Column(name = "roleId", nullable = false)
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Basic
	@Column(name = "roleName", nullable = false, length = 30)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(mappedBy = "userRoles")
	public Set<WebUser> getWebUser() {
		return webUser;
	}

	public void setWebUser(Set<WebUser> webUser) {
		this.webUser = webUser;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
