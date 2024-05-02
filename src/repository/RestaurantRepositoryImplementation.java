package repository;

import restaurantManagementModule.MenuItem;
import restaurantManagementModule.Restaurant;
import restaurantManagementModule.CuisineType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepositoryImplementation implements RestaurantRepository {

    Map<Long, Restaurant> restaurants = new HashMap<>();

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    @Override
    public void setActivationStatus(Restaurant restaurant, boolean status) {
        restaurant.setActive(status);
    }

    @Override
    public void updateMenuItem(Restaurant restaurant, MenuItem item) {
        List<MenuItem> menu = restaurant.getMenu();
        menu.add(item);
        restaurant.setMenu(menu);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurants.get(id);
    }

    @Override
    public List<Restaurant> findRestaurantByLocation(String location) {
        return restaurants.values().stream().filter(restaurant -> restaurant.getLocation().equalsIgnoreCase(location)).toList();
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        return restaurants.values().stream().filter(restaurant -> restaurant.getName().equalsIgnoreCase(name)).toList();
    }

    @Override
    public List<Restaurant> findRestaurantByType(CuisineType type) {
        return restaurants.values().stream().filter(restaurant -> restaurant.getCuisineType().equals(type)).toList();
    }

    @Override
    public List<Restaurant> findAllActiveRestaurant() {
        return restaurants.values().stream().filter(restaurant -> restaurant.isActive()).toList();
    }

    @Override
    public List<Restaurant> findAllDeactivatedRestaurant() {
        return restaurants.values().stream().filter(restaurant -> !restaurant.isActive()).toList();
    }
}
