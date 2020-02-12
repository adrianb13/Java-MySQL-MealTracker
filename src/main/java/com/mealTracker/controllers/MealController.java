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

import com.mealTracker.entity.Meal;
import com.mealTracker.entity.MealTracker;
import com.mealTracker.payload.MealRequest;
import com.mealTracker.repositories.MealRepository;
import com.mealTracker.repositories.MealTrackerRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class MealController {

	@Autowired
	private MealRepository mealRepo;
	
	@Autowired 
	private MealTrackerRepository mealTrackerRepo;
	
	@GetMapping(path = "/meals")
	public List<Meal> getAllMeals(){
		return mealRepo.findAll();
	}
	
	@GetMapping(path = "/trackers/{trackerId}/meals")
	public List<Meal> getAllMealsByMealTrackerId(@PathVariable (value = "trackerId") Long mealTrackerId){
		return mealRepo.findByMealTrackerId(mealTrackerId);
	}
	
	@PostMapping(path = "/trackers/{trackerId}/meals")
	public Optional<Meal> addMeal(@PathVariable (value = "trackerId") Long mealTrackerId, 
																@RequestBody Meal meal) {
		return mealTrackerRepo.findById(mealTrackerId).map(tracker -> {
			meal.setMealTracker(tracker);
			return mealRepo.save(meal); 
		});
				
	}
	
	@PutMapping(path = "/trackers/{trackerId}/meals/{mealId}")
	public Meal updateMeal(@PathVariable (value = "trackerId") Long mealTrackerId, 
												@PathVariable (value = "mealId") Long mealId,
												@RequestBody Meal meal) throws BadHttpRequest {
		if(mealRepo.existsById(mealId)) {
			return mealRepo.save(meal);
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/trackers/{trackerId}/meals/{mealId}")
	public void deleteMeal(@PathVariable Long mealId) {
		mealRepo.deleteById(mealId);
	}
}
