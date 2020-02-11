package com.mealTracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mealTracker.entity.MealTracker;
import com.mealTracker.payload.MealTrackerResponse;

@Repository
public interface MealTrackerRepository extends JpaRepository<MealTracker, Long> {
	
	@Query("SELECT new com.mealTracker.payload.MealTrackerResponse(t.name, m.name) FROM MealTracker t JOIN t.meals m")
	public List<MealTrackerResponse> getMealTrackerMeals();
}
