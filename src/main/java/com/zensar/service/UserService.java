package com.zensar.service;

import java.util.List;

import com.zensar.dto.UserRequest;
import com.zensar.dto.UserResponse;
import com.zensar.exception.UserNotFoundException;

public interface UserService {

	UserResponse createUser(UserRequest userRequest);

	List<UserResponse> getUsers();

	UserResponse getUserById(Long id) throws UserNotFoundException;
	
	UserResponse updateUser(UserRequest userRequest, Long id) throws UserNotFoundException;

	void deleteUserById(Long id) throws UserNotFoundException;
	
	UserResponse getUserByUsername(String username) throws UserNotFoundException;
}
