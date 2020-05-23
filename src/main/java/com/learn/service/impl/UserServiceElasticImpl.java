package com.learn.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.controller.dto.UserRequest;
import com.learn.controller.dto.UserResponse;
import com.learn.repo.ElasticSearchRepo;
import com.learn.service.UserService;

/**
 * User service elastic implementation
 * @author Nishant
 *
 */
@Service("UserServiceElasticImpl")
public class UserServiceElasticImpl implements UserService{
	private static final String USER_INDEX = "user-mst";
	
	@Autowired
	@Qualifier("UserElasticRepo")
	private ElasticSearchRepo userElasticSearchRepo;

	@Override
	public String registerUser(UserRequest userRequest) throws IOException{
		return userElasticSearchRepo.save(USER_INDEX, userRequest.getUserEntity(), userRequest.getContact());
	}

	@Override
	public UserResponse getUser(String id) throws IOException {
		return userElasticSearchRepo.findById(USER_INDEX, id, UserResponse.class).orElse(null);
	}

}
