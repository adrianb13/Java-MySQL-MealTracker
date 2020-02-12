package com.mealTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MealTrackerJavaMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealTrackerJavaMySqlApplication.class, args);
	}

}
