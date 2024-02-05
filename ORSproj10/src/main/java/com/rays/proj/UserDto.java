package com.rays.proj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Currency;

@Entity
@Table(name = "user")

public class UserDto {
	


	@Column(name = "FirstName", length = 100)
	private String firstName;
	
	@Column(name = "LastName", length = 100)
	private String lastName;
	
	@Column(name = "LoginID", length = 100)
	private String loginId;
	
	@Column(name = "Password", length = 100)
	private String password;

	@Column(name = "dob", length = 100)
	private String dob;


	@Id
	@GeneratedValue(generator = "PK")
	@GenericGenerator(name = "PK", strategy = "native")
	@Column(unique = true, nullable = false, name = "id")

	protected long id;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDOB() {
		return dob;
	}

	public void setDOB(String dOB) {
		dob = dOB;
	}

}
