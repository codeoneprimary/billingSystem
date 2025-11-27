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
@Table(name = "GST_CATEGORY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GSTCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GST_CATEGORY_ID")
	private Long gstCategoryId;

	@Column(name = "GST_PRICE", unique = true, nullable = false)
	private double gstPrice;

	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", referencedColumnName = "REG_USER_ID", nullable = false)
	private User user;

	public GSTCategory() {
	}

	public Long getGstCategoryId() {
		return gstCategoryId;
	}

	public void setGstCategoryId(Long gstCategoryId) {
		this.gstCategoryId = gstCategoryId;
	}

	public double getGstPrice() {
		return gstPrice;
	}

	public void setGstPrice(double gstPrice) {
		this.gstPrice = gstPrice;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
