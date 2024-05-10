package repository;

import exception.RestaurantNotFoundException;
import restaurantManagementModule.*;
import service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantRepositoryImplementation implements RestaurantRepository {

    private Map<Long, Restaurant> restaurants;


    public RestaurantRepositoryImplementation() {
        restaurants = new HashMap<>();
    }

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
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurants.get(id);
    }

    public List<Restaurant> findRestaurantByLocation(String location) {
        List<Restaurant> foundRestaurants = restaurants.values().stream()
                .filter(restaurant -> restaurant.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());

        if (foundRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found for location: " + location);
        }

        return foundRestaurants;
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        List<Restaurant> foundRestaurants = restaurants.values().stream()
                .filter(restaurant -> restaurant.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if (foundRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found with name: " + name);
        }

        return foundRestaurants;
    }

    @Override
    public List<Restaurant> findRestaurantByType(CuisineType type) {
        List<Restaurant> foundRestaurants = restaurants.values().stream()
                .filter(restaurant -> restaurant.getCuisineType().equals(type))
                .collect(Collectors.toList());

        if (foundRestaurants.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found for cuisine type: " + type);
        }

        return foundRestaurants;
    }

    @Override
    public List<Restaurant> findAllActiveRestaurant() {
        return restaurants.values().stream().filter(restaurant -> restaurant.isActive()).toList();
    }

    @Override
    public List<Restaurant> findAllDeactivatedRestaurant() {
        return restaurants.values().stream().filter(restaurant -> !restaurant.isActive()).toList();
    }

    @Override
    public void order(int id, Customer customer, Map<MenuItem, Integer> cart, String address, String paymentType) {
        System.out.println("\n***** Ordered Details *****");
        System.out.println("Order ID: " + id);
        int i = 1;
        for(MenuItem item: cart.keySet()) {
            System.out.printf("%d. %s | %s | ₹%s | Quantity: %s", i++, item.getItemName(), item.getType(), item.getItemPrice(), cart.get(item));
            System.out.println();
        }
        System.out.println("Total Bill: " + cartValue(cart));
        System.out.println("Thank you for shopping with us!\nEnjoy your meal.");

        Order order = new Order(id, customer, cart, address, paymentType);
        assignOrder(order);
    }

    public double cartValue(Map<MenuItem, Integer> cart) {
        double total = 0;
        for(MenuItem item: cart.keySet()) {
            total += item.getItemPrice() * cart.get(item);
        }
        return total;
    }

    public void assignOrder(Order order) {
        DeliveryAgentServiceImplementation.getInstance().addOrder(order);
    }
}
