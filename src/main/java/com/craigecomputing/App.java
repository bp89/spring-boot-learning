package com.craigecomputing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Scheduled(fixedDelay = 15 * 1000)
	@CacheEvict(value = "photoReponseById", allEntries = true)
	public String evictPhotoCache() {
		System.out.println("Eviceted.....");
		return "Evicted cache photoReponseById";
	}
}