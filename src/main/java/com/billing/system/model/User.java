package com.billing.system.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REG_USER_ID")
	private Long regUserId;

	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "MOBILE_NO", unique = true, nullable = false)
	private String mobileNo;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "USER_ROLE", nullable = false)
	private String userRole; // e.g. ROLE_USER, ROLE_ADMIN

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@Column(name = "IS_ACTIVE", nullable = false)
	private boolean isActive = true;

	@Column(name = "IS_USER_VERIFY", nullable = false)
	private boolean isUserVerify = true;

	public User() {
	}

	public Long getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(Long regUserId) {
		this.regUserId = regUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isUserVerify() {
		return isUserVerify;
	}

	public void setUserVerify(boolean isUserVerify) {
		this.isUserVerify = isUserVerify;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}