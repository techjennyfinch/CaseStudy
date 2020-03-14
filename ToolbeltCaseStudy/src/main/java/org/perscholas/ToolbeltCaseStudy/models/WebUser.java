/**
 * 
 */
package org.perscholas.ToolbeltCaseStudy.models;



import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
//	private String confirm;
//	private int roleId;
	

	private UserRole userRole;
	
	//@ManyToOne
//	private Set <Role> role;
	
	//removed RoleID and replaced with UserRole
	
	
	//constructors
	
	public WebUser() {
		
	}
	
	

	
	/**
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param userRole
	 */
	protected WebUser(String userName, String firstName, String lastName, String email, String password, UserRole userRole) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}


//constructor without userRole
	
	protected WebUser(String userName, String firstName, String lastName, String email, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	//Getters and Setters
	
	/**
	 * @return the userName
	 */
	@Id
	@Column (name = "userName", nullable = false, unique = true, length=20)
	public String getUserName() {
		return userName;
	}
	//3/12 added unique true. neeed to test this

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
	 * @return the roleId\
	 * Using UserRole instead of userroleid 3/13
	 */
//	@Basic
//	@Column(name = "UserRoleId", nullable = false, columnDefinition="int (2) default 5")
//	public int getRoleId() {
//		return roleId;
//	}
//	
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
	@ManyToOne(targetEntity=UserRole.class, cascade = CascadeType.MERGE)
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}



  //unclear if this is written properly.
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WebUser webuser = (WebUser) o;
		return userName == webuser.userName && Objects.equals(password, webuser.password);
	
	}
	
	
	//hashcode
	//tostring
	
	
	
	
	
}
