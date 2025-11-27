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
@Table(name = "ITEM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long itemId;

	@Column(name = "ITEM_CODE", unique = true, nullable = false)
	private String itemCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_CATEGORY_ID", nullable = false)
	private ItemCategory itemCategory;

	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID", nullable = false)
	private ItemUnit itemUnit;

	@Column(name = "ITEM_STOCK")
	private long itemStock;

	@Column(name = "ITEM_COMPANY", nullable = false)
	private String itemCompany;

	@Column(name = "ITEM_RATE")
	private double itemRate;

	@Column(name = "GST")
	private double gst;

	@Column(name = "IS_ACTIVE", nullable = false)
	private String isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", referencedColumnName = "REG_USER_ID", nullable = false)
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	public Item() {
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemUnit getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(ItemUnit itemUnit) {
		this.itemUnit = itemUnit;
	}

	public long getItemStock() {
		return itemStock;
	}

	public void setItemStock(long itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemCompany() {
		return itemCompany;
	}

	public void setItemCompany(String itemCompany) {
		this.itemCompany = itemCompany;
	}

	public double getItemRate() {
		return itemRate;
	}

	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

}
