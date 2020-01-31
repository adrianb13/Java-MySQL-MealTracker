package com.mealTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealTracker.entity.MealTracker;

@Repository
public interface MealTrackerRepository extends JpaRepository<MealTracker, Long> {
	
}
