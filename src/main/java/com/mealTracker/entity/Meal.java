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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "meals")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(
		mappedBy = "meal",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY
	)
	private List<Food> foods = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "Tracker_Id")
	private MealTracker mealTracker;
	
	public Meal(){
	}
	
	public Meal(String name){
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories(){
    double calories = 0;

    for(Food food : this.foods){
      calories += food.getCalories();
    }
		/* calories = Food.round(calories, 1); */
    return calories;
  }

  public double getFat(){
    double fat = 0;

    for(Food food : this.foods){
      fat += food.getFat();
    }
		/* fat = Food.round(fat, 1); */
    return fat;
  }

  public double getCarbohydrates(){
    double carbs = 0;

    for(Food food : this.foods){
      carbs += food.getCarbs();
    }
		/* carbs = Food.round(carbs, 1); */
    return carbs;
  }

  public double getProtein(){
    double protein = 0;

    for(Food food : this.foods){
      protein += food.getProtein();
    }
		/* protein = Food.round(protein, 1); */
    return protein;
  }

  public void viewFoods(){
    System.out.println("List of food items:");
    for(Food food : this.foods){
      System.out.println(food.getName());
    }
    System.out.println();
  }

  public void addFood(Food food){
    this.foods.add(food);

    System.out.println(String.format("%s is added to %s", food.getName(), this.name));
  }

  public void viewMeal(){
    System.out.printf("Total calories are %s. \n", getCalories());
    System.out.printf("Total fat is %s. \n", getFat());
    System.out.printf("Total carbs are %s. \n", getCarbohydrates());
    System.out.printf("Total protein is %s. \n", getProtein());
    if(isComplete()){
      System.out.println("This was a COMPLETE MEAL!\n");  
    } else {
      System.out.printf("This was NOT a complete meal!\n");
    }
    
    System.out.println();  
  }

  public boolean isComplete() {
    boolean fruit = false;
    boolean vegetables = false;
    boolean protein = false;
    boolean other = true;

    for (Food food : this.foods) {
      switch (food.getCategory()) {
        case Fruit:
          fruit = true;
          break;
        case Vegetable:
          vegetables = true;
          break;
        case Protein:
          protein = true;
          break;
        default: 
          other = true;
          break;
      }
    }
    
    return fruit && vegetables && protein && other;
  }
}
