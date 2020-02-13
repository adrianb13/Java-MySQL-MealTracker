package com.mealTracker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealTracker.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
	List<Meal> findByMealTrackerId(Long mealTrackerId);
	Optional<Meal> findByIdAndMealTrackerId(Long id, Long trackerId);
}
