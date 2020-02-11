package com.mealTracker.entity;

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

@Entity
@Table(name = "meals")
public class Meal extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="mealTracker_id", nullable=false) private MealTracker
	 * mealTracker;
	 */
	
	@OneToMany(targetEntity = Food.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "food_fk", referencedColumnName = "id")
	private List<Food> foods;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * public MealTracker getMealTracker() { return mealTracker; }
	 * 
	 * public void setMealName(MealTracker mealTracker) { this.mealTracker =
	 * mealTracker; }
	 */
	
	public List<Food> getFood() {
		return foods;
	}

	public void setFood(List<Food> foods) {
		this.foods = foods;
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
