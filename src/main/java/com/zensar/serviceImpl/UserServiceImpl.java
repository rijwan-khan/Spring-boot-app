package com.zensar.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zensar.dto.UserRequest;
import com.zensar.dto.UserResponse;
import com.zensar.entity.User;
import com.zensar.exception.UserNotFoundException;
import com.zensar.mapper.DemoUserMapper;
import com.zensar.mapper.DemoUserMapperImpl;
import com.zensar.repository.UserRepository;
import com.zensar.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static DemoUserMapper mapper = new DemoUserMapperImpl();

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserResponse createUser(UserRequest userRequest) {
		logger.info("** Inside createUser() **");
		User user = mapper.fromDto(userRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		logger.info("** Inside createUser() Completed**");
		return mapper.toDtoResponse(userRepository.save(user));
	}

	@Override
	public List<UserResponse> getUsers() {
		logger.info("** Inside getUsers() **");
		List<User> userList = userRepository.findAll();
		logger.info("** Inside getUsers() Completed**");
		return mapper.toDtoResponse(userList);
	}

	@Override
	public UserResponse getUserById(Long id) throws UserNotFoundException {
		logger.info("** Inside getUserById() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			logger.info("** Inside getUserById() Completed**");
			return mapper.toDtoResponse(user);
		}
		logger.info("** getUserById:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public UserResponse updateUser(UserRequest userRequest, Long id) throws UserNotFoundException {
		logger.info("** Inside updateUser() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			User userResponse = mapper.fromDto(userRequest);
			userResponse.setId(user.getId());
			userResponse.setPassword(bCryptPasswordEncoder.encode(userResponse.getPassword()));
			userRepository.save(userResponse);
			logger.info("** Inside updateUser() Completed**");
			return mapper.toDtoResponse(userResponse);
		}
		logger.info("** updateUser:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public void deleteUserById(Long id) throws UserNotFoundException {
		logger.info("** Inside deleteUserById() **");
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userRepository.delete(user);
			logger.info("** Inside deleteUserById() Completed**");
			return;
		}
		logger.info("** deleteUserById:: Some Problem Occure **");
		throw new UserNotFoundException("User Id Not Found");
	}

	@Override
	public UserResponse getUserByUsername(String username) throws UserNotFoundException {
		logger.info("** Inside getUserByUsername() **");
		Optional<User> optionalUser = userRepository.findByUsername(username);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			logger.info("** Inside getUserByUsername() Completed**");
			return mapper.toDtoResponse(user);
		}
		logger.info("** getUserByUsername:: Some Problem Occure **");
		throw new UserNotFoundException("Username Not Found");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		if (!optionalUser.isPresent())
			throw new UsernameNotFoundException(
					new StringBuffer().append("User name ").append(username).append(" not found!").toString());

		User user = optionalUser.get();
		List<GrantedAuthority> authorities = user.getRole().stream().map(role -> new SimpleGrantedAuthority(role))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
