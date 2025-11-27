package com.billing.system.serviceImpl;

import org.springframework.stereotype.Service;

import com.billing.system.dto.UserDto;
import com.billing.system.model.User;
import com.billing.system.repository.UserRepository;
import com.billing.system.services.UserService;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User userRegister(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setMobileNo(userDto.getMobileNo());
		user.setDob(userDto.getDob());
		user.setUserRole("NARMAL");
		user.setUserVerify(false);
		user.setActive(false);
		user.setCreatedDate(new Date());
		userRepository.save(user);
		return user;
	}

	@Override
	public Optional<User> findByPlainUsername(String username) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean checkPassword(User user, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
