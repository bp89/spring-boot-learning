package com.craigecomputing.domains;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {
	@Id
	private String id;
	private String userName;
	private Integer age;
}
