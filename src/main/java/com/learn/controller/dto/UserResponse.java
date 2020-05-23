package com.learn.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User response DTO
 * @author Nishant
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private String name;
	private String contact;
	private int age;
	
}