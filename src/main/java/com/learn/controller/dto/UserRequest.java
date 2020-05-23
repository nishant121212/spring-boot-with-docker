package com.learn.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank(message = "name can not be null")
	private String name;
	
	@NotBlank(message = "contact can not be null")
	private String contact;
	
	@NotNull(message = "age can not be null")
	private Integer age;
	
	/**
	 *
	 * DTO to entity
	 * @return User
	 */
	public User getUserEntity() {
		return new User(this.contact, this.name, this.age);
	}
	
}
