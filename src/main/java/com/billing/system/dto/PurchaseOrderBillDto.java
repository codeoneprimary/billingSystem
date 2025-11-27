package com.billing.system.dto;

import java.util.List;

public class PurchaseOrderBillDto {

	private String customerName;

	private String mobileNo;

	private String emailId;

	private String address;

	private List<ItemDto> itemDto;

	private double discount;

	private double totalBillAmount;

	public List<ItemDto> getItemDto() {
		return itemDto;
	}

	public void setItemDto(List<ItemDto> itemDto) {
		this.itemDto = itemDto;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
