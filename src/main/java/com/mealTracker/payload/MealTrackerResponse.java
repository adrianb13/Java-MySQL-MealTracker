package com.mealTracker.payload;

public class MealTrackerResponse {
	private String trackerName;
	private String mealName;
	
	public MealTrackerResponse (String trackerName, String mealName) {
		this.trackerName = trackerName;
		this.mealName = mealName;
	}
	
	public String getTrackerName() {
		return trackerName;
	}
	
	public void setTrackerName(String trackerName) {
		this.trackerName = trackerName;
	}
	
	public String getMealName() {
		return mealName;
	}
	
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	
	
}
