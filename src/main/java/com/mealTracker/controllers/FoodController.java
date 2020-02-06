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

import com.mealTracker.entity.Food;
import com.mealTracker.payload.FoodRequest;
import com.mealTracker.repositories.FoodRepository;

import javassist.tools.web.BadHttpRequest;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	private FoodRepository foodRepo;
	
	@GetMapping(path = "/food")
	public List<Food> getAllFoods(){
		return foodRepo.findAll();
	}
	
	@PostMapping(path = "/food")
	public Food addFood(@RequestBody FoodRequest fRequest) {
		return foodRepo.save(fRequest.getFood());
	}
	
	@PutMapping(path = "/food/{id}")
	public Food updateFood(@PathVariable Long id, @RequestBody FoodRequest fRequest) throws BadHttpRequest {
		if(foodRepo.existsById(id)) {
			return foodRepo.save(fRequest.getFood());
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/food/{id}")
	public void deleteFood(@PathVariable Long id) {
		foodRepo.deleteById(id);
	}
}
