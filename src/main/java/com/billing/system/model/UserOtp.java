package com.billing.system.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "USER_OTP")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserOtp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OTP_ID")
	private Long otpId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REG_USER_ID", nullable = false)
	private User user;

	@Column(name = "OTP", nullable = false)
	private String otp;

	@Column(name = "IS_ACTIVE", nullable = false)
	private boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	public UserOtp() {
	}

	public Long getOtpId() {
		return otpId;
	}

	public void setOtpId(Long otpId) {
		this.otpId = otpId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
