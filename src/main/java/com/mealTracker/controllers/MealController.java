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

import com.mealTracker.entity.Meal;
import com.mealTracker.payload.MealRequest;
import com.mealTracker.repositories.MealRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class MealController {

	@Autowired
	private MealRepository mealRepo;
	
	@GetMapping(path = "/meals")
	public List<Meal> getAllMeals(){
		return mealRepo.findAll();
	}
	
	@PostMapping(path = "/meals")
	public Meal addMeal(@RequestBody MealRequest mRequest) {
		return mealRepo.save(mRequest.getMeal());
	}
	
	@PutMapping(path = "/meals/{id}")
	public Meal updateMeal(@PathVariable Long id, @RequestBody MealRequest mRequest) throws BadHttpRequest {
		if(mealRepo.existsById(id)) {
			return mealRepo.save(mRequest.getMeal());
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/meals/{id}")
	public void deleteMeal(@PathVariable Long id) {
		mealRepo.deleteById(id);
	}
}
