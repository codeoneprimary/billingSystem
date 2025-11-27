package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.ItemQuotation;

public interface ItemQuotationRepository extends JpaRepository<ItemQuotation, Long> {

}
