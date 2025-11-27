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
@Table(name = "PURCHASE_ORDER_PAYMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PurchaseOrderPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID")
	private Long paymentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PO_ID", nullable = false)
	private PurchaseOrder purchaseOrder;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	@Column(name = "PAYMENT_AMOUNT", nullable = false)
	private String paymentAmount;

	@Column(name = "PAYMENT_STATUS", nullable = false)
	private String paymentStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", referencedColumnName = "REG_USER_ID", nullable = false)
	private User user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	public PurchaseOrderPayment() {
	}

}
