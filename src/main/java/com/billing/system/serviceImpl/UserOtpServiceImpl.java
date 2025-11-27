package com.billing.system.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billing.system.dto.UserOtpDto;
import com.billing.system.model.User;
import com.billing.system.model.UserOtp;
import com.billing.system.repository.UserOtpRepository;
import com.billing.system.services.UserOtpService;
import com.billing.system.util.OtpUtil;
import com.billing.system.util.SmaUtil;

@Service
public class UserOtpServiceImpl implements UserOtpService {

	private final UserOtpRepository userOtpRepository;

	@Autowired
	private OtpUtil otpUtil;
	@Autowired
	private SmaUtil smaUtil;

	public UserOtpServiceImpl(UserOtpRepository userOtpRepository) {
		this.userOtpRepository = userOtpRepository;
	}

	@Override
	public boolean verifyUserOtp(UserOtpDto userOtpDto) {
		User user = new User();
		user.setRegUserId(userOtpDto.getRegUserId());
		user.setUsername(userOtpDto.getUsername());
		Optional<List<UserOtp>> userOtpList = userOtpRepository.findByUserAndIsActiveTrue(user);

		if (userOtpList.isPresent()) {
			for (UserOtp userOtp : userOtpList.get()) {
				if (userOtp.getOtp().equals(userOtpDto.getOtp())) {
					userOtpRepository.save(userOtp);
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void createUserOtp(User user) {
		String otp = otpUtil.generateOtp();
		UserOtp userOtp = new UserOtp();
		userOtp.setUser(user);
		userOtp.setOtp(otp);
		userOtp.setIsActive(true);
		userOtp.setCreatedDate(new Date());
		userOtpRepository.save(userOtp);
		smaUtil.sendOtp(user.getMobileNo(), otp);
	}

}
