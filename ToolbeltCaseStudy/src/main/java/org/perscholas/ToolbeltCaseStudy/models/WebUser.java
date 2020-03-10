/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * @author Jenny
 * Class for info from webpage user registration
 */

@Entity
public class WebUser {

	
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
//	private int roleId;
	private UserRole userRole;
	
	//@ManyToOne
//	private Set <Role> role;
	
	//removed RoleID and replaced with UserRole
	
	
	//constructors
	
	public WebUser() {
		
	}
	
	protected WebUser(String userName, String firstName, String lastName, String email, String password) {
	
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	//	this.roleId = roleId;
	}

	
	//Getters and Setters
	
	/**
	 * @return the userName
	 */
	@Id
	@Column (name = "userName", nullable = false, length=20)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	@Basic
	@Column(name = "firstName", nullable = false, length=20)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Basic
	@Column(name = "lastName", nullable = false, length=30)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	@Basic
	@Column(name = "email", nullable = false, length=50)
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	@Basic
	@Column(name = "password", nullable = false, length=20)
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roleId
	 */
//	@Basic
//	@Column(name = "UserRoleId", nullable = false, columnDefinition="int (2) default 5")
//	public int getRoleId() {
//		return roleId;
//	}
//
//	/**
//	 * @param roleId the roleId to set
//	 */
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}

	/**
	 * @return the userRole
	 */
	@ManyToOne
	@JoinColumn (name="roleId" )	
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
	
	
	
	
}
