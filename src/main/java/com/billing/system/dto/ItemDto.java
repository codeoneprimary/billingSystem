package com.billing.system.dto;

public class ItemDto {

	private Long itemId;
	private String itemCode;
	private String itemName;
	private String itemCompany;
	private String unit;
	private double itemRate;
	private long itemQuantity;
	private double gst;
	private double discount;
	private double totalPrice;

	public ItemDto() {
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCompany() {
		return itemCompany;
	}

	public void setItemCompany(String itemCompany) {
		this.itemCompany = itemCompany;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getItemRate() {
		return itemRate;
	}

	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}

	public long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
