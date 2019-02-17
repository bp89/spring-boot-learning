package com.craigecomputing.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craigecomputing.services.JsonPlaceholderApiService;

@RestController
public class JsonPlaceholderPhotoController {

	@Autowired
	JsonPlaceholderApiService jsonPlaceholderApiService;

	@RequestMapping("/photos/{id}")
	public String getPhotoById(@PathVariable int id) throws ClientProtocolException, IOException {
		return jsonPlaceholderApiService.getPhotoById(id);
	}

	
}