package com.zensar.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.zensar.dto.UserRequest;
import com.zensar.dto.UserResponse;
import com.zensar.entity.User;

@Mapper
public interface DemoUserMapper {
//	@Mapping(source = "username", target = "name")
	UserRequest toDtoRequest(User user);

	UserResponse toDtoResponse(User user);

//	@InheritInverseConfiguration(name = "toDto")
	User fromDto(UserRequest userRequest);

	List<UserRequest> toDtoRequest(List<User> user);

	List<UserResponse> toDtoResponse(List<User> user);

}
