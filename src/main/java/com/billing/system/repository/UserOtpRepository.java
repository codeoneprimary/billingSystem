package com.billing.system.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.system.model.User;
import com.billing.system.model.UserOtp;

public interface UserOtpRepository extends JpaRepository<UserOtp, Long> {

	Optional<List<UserOtp>> findByUserAndIsActiveTrue(User user);
}
