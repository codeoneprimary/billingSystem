package com.billing.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.GSTCategory;

public interface GSTCategoryRepository extends JpaRepository<GSTCategory, Long> {

}
