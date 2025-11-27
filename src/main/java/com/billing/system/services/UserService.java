package com.billing.system.services;

import java.util.Optional;

import com.billing.system.dto.UserDto;
import com.billing.system.model.User;

public interface UserService {

	User userRegister(UserDto userDto);

	Optional<User> findByPlainUsername(String username);

	boolean checkPassword(User user, String password);

}
