package service;

import restaurantManagementModule.CuisineType;
import restaurantManagementModule.MenuItem;
import restaurantManagementModule.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    public void addRestaurant(Restaurant restaurant);

    public void activateRestaurant(long restaurantId);

    public void deActivateRestaurant(long restaurantId);

    public void updateMenuItem(Restaurant restaurant, MenuItem item);

    public Restaurant getRestaurantById(long id);

    public List<Restaurant> findRestaurantByLocation(String location);

    public List<Restaurant> findRestaurantByName(String name);

    public List<Restaurant> findRestaurantByType(CuisineType type);

    public List<Restaurant> findAllActiveRestaurant();

    public List<Restaurant> findAllDeactivatedRestaurant();

    public void order(Map<MenuItem, Integer> cart);
}
