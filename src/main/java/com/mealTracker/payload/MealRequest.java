package com.mealTracker.payload;

import com.mealTracker.entity.Meal;

public class MealRequest {
	private Meal meal;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
}
