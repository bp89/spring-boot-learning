package com.craigecomputing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.craigecomputing.dtos.Customer;
import com.craigecomputing.dtos.CustomerConverter;

@RestController
public class TestController {

	@RequestMapping(value="/getData", method=RequestMethod.GET)
	public ResponseEntity<String> getData(@RequestParam(value="customerType") Customer customer) {
		return ResponseEntity.ok(customer.name());
	}

	@InitBinder
	public void initBinder(final WebDataBinder webdataBinder) {
		webdataBinder.registerCustomEditor(Customer.class, new CustomerConverter());
	}
}