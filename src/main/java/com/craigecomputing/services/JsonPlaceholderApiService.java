package com.craigecomputing.services;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class JsonPlaceholderApiService {
	DefaultHttpClient httpClient = new DefaultHttpClient();

	@Cacheable(value="photoReponseById")
	public String getPhotoById(int id) throws ClientProtocolException, IOException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		HttpGet getRequest = new HttpGet("https://jsonplaceholder.typicode.com/photos/" + id);
		getRequest.setHeader("accept", "application/json");

		HttpResponse response = httpClient.execute(getRequest);

		System.out.println("Fetching data from JsonPlaceholderApi...");
		return EntityUtils.toString(response.getEntity());
	}

}
