package repository;

import restaurantManagementModule.CuisineType;
import restaurantManagementModule.MenuItem;
import restaurantManagementModule.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    public void addRestaurant(Restaurant restaurant);

    public void setActivationStatus(Restaurant restaurant,boolean status);

    public void updateMenuItem(Restaurant restaurant, MenuItem item);

    public Restaurant getRestaurantById(long id);

    public List<Restaurant> findRestaurantByLocation(String location);

    public List<Restaurant> findRestaurantByName(String name);

    public List<Restaurant> findRestaurantByType(CuisineType type);

    public List<Restaurant> findAllActiveRestaurant();

    public List<Restaurant> findAllDeactivatedRestaurant();

}
