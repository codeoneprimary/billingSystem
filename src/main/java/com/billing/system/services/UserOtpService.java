package com.billing.system.services;

import com.billing.system.dto.UserOtpDto;
import com.billing.system.model.User;

public interface UserOtpService {

	boolean verifyUserOtp(UserOtpDto userotp);

	void createUserOtp(User user);

}
