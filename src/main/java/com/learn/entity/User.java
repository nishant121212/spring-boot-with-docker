package com.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * elasticsearch users-mst entity
 * @author Nishant
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String contact;
	private String name;
	private int age;	
	
}
