package com.mealTracker.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "meals")
public class Meal extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@JsonManagedReference
	@OneToMany(
		mappedBy = "meal", 
		targetEntity = Food.class,
		cascade = CascadeType.ALL, 
		fetch = FetchType.LAZY)
	private List<Food> foods;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="mealTracker_id", nullable=false)
	private MealTracker mealTracker;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
		
	public void setMealTracker(MealTracker mealTracker) {
		this.mealTracker = mealTracker;
	}
	
	public void removeMealTracker() {
		this.mealTracker.removeMeal(this);
		this.mealTracker = null;
	}

	/*
	 * public double getCalories(){ double calories = 0;
	 * 
	 * for(Food food : this.foods){ calories += food.getCalories(); } calories =
	 * Food.round(calories, 1); return calories; }
	 * 
	 * public double getFat(){ double fat = 0;
	 * 
	 * for(Food food : this.foods){ fat += food.getFat(); } fat = Food.round(fat,
	 * 1); return fat; }
	 * 
	 * public double getCarbohydrates(){ double carbs = 0;
	 * 
	 * for(Food food : this.foods){ carbs += food.getCarbs(); } carbs =
	 * Food.round(carbs, 1); return carbs; }
	 * 
	 * public double getProtein(){ double protein = 0;
	 * 
	 * for(Food food : this.foods){ protein += food.getProtein(); } protein =
	 * Food.round(protein, 1); return protein; }
	 * 
	 * public boolean isComplete() { boolean fruit = false; boolean vegetables =
	 * false; boolean protein = false; boolean other = true;
	 * 
	 * for (Food food : this.foods) { switch (food.getCategory()) { case Fruit:
	 * fruit = true; break; case Vegetable: vegetables = true; break; case Protein:
	 * protein = true; break; default: other = true; break; } }
	 * 
	 * return fruit && vegetables && protein && other; }
	 */
}
