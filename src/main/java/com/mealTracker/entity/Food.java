package com.mealTracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@Entity
@Table (name = "foods")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private double calories;
	
	private double fat;
	
	private double carbs;
	
	private double protein;
	
	private Category category;
	
	private ArrayList<Category> categories = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "Meal_Id")
	private Meal meal;
	
	Food(String name, double fat, double carbs, double protein, Category category){
		this.name = name;
		this.calories = setCalories(carbs, fat, protein);
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
		this.category = category;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getCalories() {
		return this.calories;
	}
	
	public double setCalories(double fat, double carbs, double protein) {
		double total = (9 * fat) + (4 * carbs) + (4 * protein);
		if(total > 0) {
			return round(total, 1);
		} else {
			return 0;
		}
	}
	
	public double getFat() {
		return this.fat;
	}
	
	public void setFat(double fat) {
		this.fat = fat;
	}
	
	public double getCarbs() {
		return this.carbs;
	}
	
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	
	public double getProtein() {
		return this.protein;
	}
	
	public void setProtein(double protein) {
		this.protein = protein;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public static double round(double n, int decimalPlaces) {
    if(n > 0){
      BigDecimal instance = new BigDecimal(Double.toString(n)); //User STRING CONSTRUCTOR
      instance = instance.setScale(decimalPlaces, RoundingMode.HALF_UP);
      return instance.doubleValue(); //Make sure to return DOUBLE VALUE
    } else {
      throw new IllegalArgumentException();
    }
  }
}
