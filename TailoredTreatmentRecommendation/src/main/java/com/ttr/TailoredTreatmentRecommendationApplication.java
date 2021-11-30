package com.ttr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TailoredTreatmentRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TailoredTreatmentRecommendationApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
