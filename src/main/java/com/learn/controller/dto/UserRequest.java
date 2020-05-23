package com.learn.controller.dto;

import com.learn.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User request DTO
 * @author Nishant
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest{
	private String name;
	private String contact;
	private int age;
	
	/**
	 *
	 * DTO to entity
	 * @return User
	 */
	public User getUserEntity() {
		return new User(this.contact, this.name, this.age);
	}
	
}
