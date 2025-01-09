package com.food.service;

import com.food.model.Category;
import com.food.model.Food;
import com.food.model.Restaurant;
import com.food.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegitarain,
                                         boolean isNonVeg,
                                         boolean isSeasonal,
                                         String foodCategory
    );

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;

    public Food UpdateAvailabilityStatus(Long foodId) throws Exception;
}
