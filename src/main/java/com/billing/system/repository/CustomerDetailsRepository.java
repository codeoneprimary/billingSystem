package com.billing.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

	Optional<CustomerDetails> findByMobileNo(String mobile);

	boolean existsByMobileNo(String mobile);
}
