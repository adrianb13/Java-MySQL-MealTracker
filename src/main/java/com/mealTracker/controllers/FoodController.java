package com.mealTracker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mealTracker.entity.Food;
import com.mealTracker.payload.FoodRequest;
import com.mealTracker.repositories.FoodRepository;
import com.mealTracker.repositories.MealRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000", "https://adrianb13.github.io/ReactRedux-MealTracker/", "https://adrianb13.github.io/ReactRedux-MealTracker"})
@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private MealRepository mealRepo;
	
	@GetMapping(path = "/food/{mealId}")
	public List<Food> getAllFoods(@PathVariable (value = "mealId") Long mealId){
		return foodRepo.findByMealId(mealId);
	}
	
	@PostMapping(path = "/food/{mealId}")
	public Optional<Food> addFood(@PathVariable (value = "mealId") Long mealId,
											@RequestBody Food food) {
		return mealRepo.findById(mealId).map(meal -> {
			food.setMeal(meal);
			return foodRepo.save(food);
		});
	}
	
	@PutMapping(path = "/food/{mealId}/{foodId}")
	public Food updateFood(@PathVariable (value = "mealId") Long mealId,
												@PathVariable (value ="foodId") Long foodId, 
												@RequestBody Food food) throws BadHttpRequest {
		if(foodRepo.existsById(foodId)) {
			return foodRepo.save(food);
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/food/{foodId}")
	public void deleteFood(@PathVariable (value ="foodId") Long id) {
		foodRepo.deleteById(id);
	}
}
