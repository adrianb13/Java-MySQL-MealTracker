package com.mealTracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealTracker.entity.Meal;
import com.mealTracker.entity.MealTracker;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
	public List<Meal> findByMealTracker_Id(Long id);
}
