package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Long> {

}
