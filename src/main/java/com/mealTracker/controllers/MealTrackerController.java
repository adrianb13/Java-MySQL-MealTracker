package com.mealTracker.controllers;

import java.util.List;
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
import com.mealTracker.payload.MealTrackerResponse;
import com.mealTracker.repositories.MealRepository;
import com.mealTracker.repositories.MealTrackerRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000", "https://adrianb13.github.io/ReactRedux-MealTracker/", "https://adrianb13.github.io"})
@RestController
@RequestMapping("/api")
public class MealTrackerController {

	@Autowired
	private MealTrackerRepository mealTrackerRepo;
	
	@GetMapping(path = "/trackers")
	public List<MealTracker> getAllMealTrackers(){
		return mealTrackerRepo.findAll();
		/*
		 * List<MealTracker> mealTrackers = new ArrayList<>();
		 * mealTrackerRepo.findAll().forEach(mealTrackers :: add); return mealTrackers;
		 */
	}
	
	@GetMapping(path = "/trackers/meals")
	public List<MealTrackerResponse> getMealTrackerMeals(){
		return mealTrackerRepo.getMealTrackerMeals();
	}
		
	@PostMapping(path = "/trackers")
	public MealTracker addMealTracker(@RequestBody MealTracker mtRequest) {
		return mealTrackerRepo.save(mtRequest);
	}
		
	@PutMapping(path = "/trackers/{id}")
	public MealTracker updateMealTracker(@PathVariable Long id, @RequestBody MealTracker mtRequest) throws BadHttpRequest {
		if(mealTrackerRepo.existsById(id)) {
			return mealTrackerRepo.save(mtRequest);
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/trackers/{id}")
	public void deleteMealTracker(@PathVariable Long id) {
		mealTrackerRepo.deleteById(id);
	}
}
