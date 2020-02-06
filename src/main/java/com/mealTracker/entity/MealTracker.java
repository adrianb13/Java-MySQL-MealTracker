package com.mealTracker.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "mealtrackers")
public class MealTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String trackerName;
	
	@OneToMany(
		targetEntity = Meal.class,
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER
	)
	@JoinColumn(
		name = "meal_fk", 
		referencedColumnName = "id"
	)
	private List<Meal> meals;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackerName() {
		return trackerName;
	}

	public void setTrackerName(String trackerName) {
		this.trackerName = trackerName;
	}
	
	public List<Meal> getMeals(){
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
