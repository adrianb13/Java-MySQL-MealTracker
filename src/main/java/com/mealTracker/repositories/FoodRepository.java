package com.mealTracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealTracker.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
