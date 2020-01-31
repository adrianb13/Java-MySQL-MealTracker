package com.mealTracker.controllers;

import java.util.ArrayList;
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
		List<Food> foods = new ArrayList<>();
		foodRepo.findAll().forEach(foods :: add);
		return foods;
	}
	
	@PostMapping(path = "/food")
	public Food addFood(@RequestBody Food food) {
		foodRepo.save(food);
		return food;
	}
	
	@PutMapping(path = "/food/{id}")
	public Food updateFood(@PathVariable Long id, @RequestBody Food food) throws BadHttpRequest {
		if(foodRepo.existsById(id)) {
			return foodRepo.save(food);
		} else {
			throw new BadHttpRequest();
		}
	}
	
	@DeleteMapping(path = "/food/{id}")
	public void deleteFood(@PathVariable Long id) {
		foodRepo.deleteById(id);
	}
}
