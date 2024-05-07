package service;

import repository.RestaurantRepository;
import repository.RestaurantRepositoryImplementation;
import restaurantManagementModule.CuisineType;
import restaurantManagementModule.MenuItem;
import restaurantManagementModule.Restaurant;

import java.util.List;
import java.util.Map;

public class RestaurantServiceImplementation implements RestaurantService {

    RestaurantRepository restaurantRepository = new RestaurantRepositoryImplementation();

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }
    @Override
    public void activateRestaurant(long id) {
        restaurantRepository.setActivationStatus(restaurantRepository.getRestaurantById(id), true);
    }

    @Override
    public void deActivateRestaurant(long id) {
        restaurantRepository.setActivationStatus(restaurantRepository.getRestaurantById(id), false);
    }

    @Override
    public void updateMenuItem(Restaurant restaurant, MenuItem item) {
        restaurantRepository.updateMenuItem(restaurant, item);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.getRestaurantById(id);
    }

    @Override
    public List<Restaurant> findRestaurantByLocation(String location) {
        return restaurantRepository.findRestaurantByLocation(location);
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }

    @Override
    public List<Restaurant> findRestaurantByType(CuisineType type) {
        return restaurantRepository.findRestaurantByType(type);
    }

    @Override
    public List<Restaurant> findAllActiveRestaurant() {
        return restaurantRepository.findAllActiveRestaurant();
    }

    @Override
    public List<Restaurant> findAllDeactivatedRestaurant() {
        return restaurantRepository.findAllDeactivatedRestaurant();
    }

    @Override
    public void order(Map<MenuItem, Integer> cart) {
        restaurantRepository.order(cart);
    }
}
