package com.billing.system.model;

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

@Entity
@Table(name = "PURCHASE_ORDER_ITEM")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PurchaseOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PO_ITEM_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PO_ID")
	private PurchaseOrder purchaseOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;

	@Column(name = "ITEM_CODE", nullable = false)
	private String itemCode;

	@Column(name = "RATE")
	private double itemRate;

	@Column(name = "QUANTITY")
	private long itemQuantity;

	@Column(name = "UNIT")
	private String unit;

	@Column(name = "GST")
	private double gst;

	@Column(name = "DISCOUNT")
	private double discount;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	public PurchaseOrderItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
