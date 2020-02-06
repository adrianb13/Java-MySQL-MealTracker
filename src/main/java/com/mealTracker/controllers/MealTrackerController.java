package com.mealTracker.controllers;

import java.util.ArrayList;
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

import com.mealTracker.entity.MealTracker;
import com.mealTracker.payload.MealTrackerRequest;
import com.mealTracker.payload.MealTrackerResponse;
import com.mealTracker.repositories.FoodRepository;
import com.mealTracker.repositories.MealRepository;
import com.mealTracker.repositories.MealTrackerRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class MealTrackerController {

	@Autowired
	private MealTrackerRepository mealTrackerRepo;
	
	@Autowired
	private MealRepository mealRepo;

	/* Working */
	@GetMapping(path = "/trackers")
	public List<MealTracker> getAllMealTrackers(){
		return mealTrackerRepo.findAll();
		/*
		 * List<MealTracker> mealTrackers = new ArrayList<>();
		 * mealTrackerRepo.findAll().forEach(mealTrackers :: add); return mealTrackers;
		 */
	}
	
	/* Working */
	@GetMapping(path = "/trackers/meals")
	public List<MealTrackerResponse> getMealTrackerMeals(){
		return mealTrackerRepo.getMealTrackerMeals();
	}
		
	/* Working */
	@PostMapping(path = "/trackers")
	public MealTracker addMealTracker(@RequestBody MealTrackerRequest mtRequest) {
		return mealTrackerRepo.save(mtRequest.getMealTracker());
	}
		
	/* Working */
	@PutMapping(path = "/trackers/{id}")
	public MealTracker updateMealTracker(@PathVariable Long id, @RequestBody MealTrackerRequest mtRequest) throws BadHttpRequest {
		if(mealTrackerRepo.existsById(id)) {
			return mealTrackerRepo.save(mtRequest.getMealTracker());
		} else {
			throw new BadHttpRequest();
		}
	}
	
	/* Working */
	@DeleteMapping(path = "/trackers/{id}")
	public void deleteMealTracker(@PathVariable Long id) {
		mealTrackerRepo.deleteById(id);
	}
}
