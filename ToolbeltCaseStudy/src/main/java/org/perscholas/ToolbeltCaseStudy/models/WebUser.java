
package org.perscholas.ToolbeltCaseStudy.models;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Jenny Class for info from webpage user registration and login.
 */

@Entity
@Table(name = "webuser")
public class WebUser {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirm; // removed password confirmation in form.

	private Collection<UserRole> userRoles;

	// constructors

	public WebUser() {

	}

//constructor without userRole

	public WebUser(String userName, String firstName, String lastName, String email, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	protected WebUser(String userName, String firstName, String lastName, String email, String password, String confirm,
			Collection<UserRole> userRoles) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
		this.userRoles = userRoles;
	}

	// this one is without the confirm password.
	protected WebUser(String userName, String firstName, String lastName, String email, String password,
			Collection<UserRole> userRoles) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}

	// Getters and Setters

	@Id
	@Column(name = "userName", nullable = false, unique = true, length = 30)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Basic
	@Column(name = "firstName", nullable = false, length = 20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Basic
	@Column(name = "lastName", nullable = false, length = 30)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "password", nullable = false, length = 80)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	@ManyToMany
	public Collection<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Collection<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		WebUser webuser = (WebUser) o;
		return userName == webuser.userName && Objects.equals(password, webuser.password);

	}

	@Override
	public String toString() {
		return "WebUser [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirm=" + confirm + ", userRoles=" + userRoles + "]";
	}

}
