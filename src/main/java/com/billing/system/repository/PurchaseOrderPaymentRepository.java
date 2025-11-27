package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.PurchaseOrderPayment;

public interface PurchaseOrderPaymentRepository extends JpaRepository<PurchaseOrderPayment, Long> {

}
