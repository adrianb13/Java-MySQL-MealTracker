# Spring Boot, Java, MySQL - Meal Tracker
Back-end for React, Redux, Spring Boot, Java & MySQL application - Meal Tracker. This portion uses Spring Boot, Java, and MySQL.

Front-end Repo: https://github.com/adrianb13/ReactRedux-MealTracker

## About

This is the back-end of a React, Redux, Spring Boot, Java & MySQL application.  The application was created to help a user keep track of their daily nutritional intake.  People try to stay healthy and eat the right things but it's hard to keep track of what you are eating.  This application helps you with that.  

## Database Breakdown
The application takes advantage of 3 Tables: "MealTracker," "Meals," "Food" (items of each meal). I take advantage of the bidirectional relationships of One-to-Many Many-to-One mappings offered by MySQL.  A user can create as many trackers as they want.  A "MealTracker" has many "Meals" and the direction goes both ways as far as data linking.  A "Meal" can have many "Food" or food items and again the data is linked in both directions.

I used the bidirectional linking to allow the parent data to view all it's children without requiring the parent to make all it's changes to it's children.  Each child can be updated, viewed, deleted, independently from it's parent while still keeping it's link to it's parent.   - For example, I can select a "MealTracker" and view all it's "Meals."  I can then choose a "Meal" to view all the "Food" that made up the "Meal." I can then update and delete each one independently as needed.
  - For data purposes, I can GET REQUEST a "MealTracker" and view all it's connected downstream links all down to the "Food" within a specific "Meal."  This allows me to lower the number of API calls needed to get the data presented to the User when presenting the larger picture.  On the opposite side, for quicker access and a more direct API call, I can view each item independently if needed when a User just wants one item and any level, which can then be updated/deleted if needed.
  
The idea was trying to keep the application as quick as possible while dealing with what can turn into a large amount of data for a single user.  A diligent user can have a tracker that tracks every single snack they take which can be labeled as a "Meal."  Then that "Meal" will hold all those items they snacked on.  If you are what is called a "grazer," you eat a lot of smaller portions than your traditional big meals.  So you will have plenty of more entries that a normal user.  Or let's say you are Michael Phelps who eats 12,000 calories a day as part of your training.  You will also be data heavy.

## Ability To Handle Heavy Data
This is where Spring Boot and Java come into play.  Java allows for this multi-threaded data access that will be needed as a user gets more involved with their application and trying to present all this data to them.  Java is robust and capable of handling all this data that will come as part of the application as users get more involved. Spring Boot simplifies all these data connections for me as a developer which allows me the ease for expandabitity of data and features for the application.  Let's say a user wants more details for their meals that require more data inputs/outputs.  Spring Boot helps with the creation of that allow with the API involved to get this data to the User.

## Ability For Greater Expansion
Right now the application is focused on simplicity.  That is why I chose a One-to-Many top-down style relationship.  It a sort of pyramid style breakdown.  It can be expanded into a Many-to-Many style relationship in the future as an Enterprise/Business level application.  

Let's say we want each "Meal" to have a Many-to-Many with each "Food."  So common food items can be inputed as part of a pre-determined list a user can scroll through to pre-select as opposed to manually input nutritional data. You can also have a Many to Many connection between a "Meal Tracker" and a "Meal," essentially a "Meal Tracker" = "1 User".  Back to a pre-determined list, we can add corporate sponsors and their meals as part of that list.  Let's say John's Pizza is a local sponsor.  We can add John's Pizza's entire menu as part of a pre-determined "Meal" list that all Users can select from.  It is kind of like advertising because they get to show off their food and we charge them a sponsor fee to have us do that.  This is just one idea.  From here, it can include location based menus with pre-determined lists.  So the possibilities are endless.
