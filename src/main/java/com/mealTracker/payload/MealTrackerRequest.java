package com.mealTracker.payload;

import com.mealTracker.entity.MealTracker;

public class MealTrackerRequest {
	private MealTracker mealTracker;

	public MealTracker getMealTracker() {
		return mealTracker;
	}

	public void setMealTracker(MealTracker mealTracker) {
		this.mealTracker = mealTracker;
	}
}
