package com.mealTracker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "mealtrackers")
public class MealTracker extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	

	@JsonManagedReference
	@OneToMany(
		mappedBy = "mealTracker",
		targetEntity = Meal.class,
		cascade=CascadeType.REMOVE,
		fetch = FetchType.EAGER
	)
	private List<Meal> meals;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Meal> getMeals(){
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public void removeMeal(Meal meal) {
		this.meals.remove(meal);
	}
}
