package com.mealTracker.entity;

import java.util.ArrayList;
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

@Entity
@Table (name = "mealtrackers")
public class MealTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String trackerName;
	
	@OneToMany(
		mappedBy = "mealTracker",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	private List<Meal> meals = new ArrayList<>();
	
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
	
	public void addMeal(Meal meal) {
		this.meals.add(meal);
		
		System.out.print(String.format("%s was added to your tracker.", meal.getName()));
    System.out.println();
	}
	
	public void viewMeals(){
    System.out.println("List of meals:");
    for (Meal meal : this.meals) {
      System.out.println(meal.getName());
    }
    System.out.println();
  }

  public int getMealCount(){
    return this.meals.size();
  }
}
