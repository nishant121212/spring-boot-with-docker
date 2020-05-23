package com.learn.service;

import java.io.IOException;

import com.learn.controller.dto.UserRequest;
import com.learn.controller.dto.UserResponse;

/**
 * User service
 * @author Nishant
 *
 */
public interface UserService {
	
	/**
	 * register a new user
	 * @param user
	 * @return Id
	 * @throws IOException 
	 */
	String registerUser(UserRequest userRequest) throws IOException;
	
	/**
	 * fetch user details
	 * @param id user id
	 * @return UserResponse user details
	 * @throws IOException 
	 */
	UserResponse getUser(String id) throws IOException;

}
