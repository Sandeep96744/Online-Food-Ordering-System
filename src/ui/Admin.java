package ui;

import restaurantManagementModule.*;
import service.RestaurantService;
import service.RestaurantServiceImplementation;

import java.time.LocalTime;
import java.util.List;

public class Admin {
    public static void main(String[] args) {
        RestaurantService repo = new RestaurantServiceImplementation();


        Restaurant restaurant1 = new FastFoodRestaurant(101, "Bigg Boss", "Kolkata",
                LocalTime.parse("09:00"), LocalTime.parse("19:00"), true);

        Restaurant restaurant2 = new FineDiningRestaurant(102, "Sanjha Chulha", "Delhi",
                LocalTime.parse("09:00"), LocalTime.parse("20:00"), false);

        Restaurant restaurant3 = new FineDiningRestaurant(103, "Desi Lane", "Kolkata",
                LocalTime.parse("09:00"), LocalTime.parse("19:00"), true);


        repo.addRestaurant(restaurant1);
        repo.updateMenuItem(restaurant1, new MenuItem("Noodles", ItemType.VEG, 149.0));
        repo.updateMenuItem(restaurant1, new MenuItem("Soup", ItemType.VEG,119.0));
        repo.updateMenuItem(restaurant1, new MenuItem("Manchurian", ItemType.VEGAN, 349.0));

        repo.addRestaurant(restaurant2);
        repo.updateMenuItem(restaurant2, new MenuItem("Chicken Biryani", ItemType.NON_VEG, 399.0));
        repo.updateMenuItem(restaurant2, new MenuItem("Paneer Masala", ItemType.VEG, 249.0));
        repo.updateMenuItem(restaurant2, new MenuItem("Butter Naan", ItemType.VEG, 25.0));


        repo.addRestaurant(restaurant3);
        repo.updateMenuItem(restaurant3, new MenuItem("Crispy Baby Corn", ItemType.VEG, 199.0));
        repo.updateMenuItem(restaurant3, new MenuItem("Panner Chilli", ItemType.VEG, 299.0));

        List<Restaurant> restaurantList = repo.findAllActiveRestaurant();
        System.out.println("Active Restaurants: ");
        for(Restaurant restaurant: restaurantList) {
            System.out.println(restaurant.getName());
            restaurant.displayMenu();
        }

        repo.deActivateRestaurant(101);
        repo.activateRestaurant(102);


        restaurantList = repo.findAllActiveRestaurant();
        System.out.println("Active Restaurants: ");
        for(Restaurant restaurant: restaurantList) {
            System.out.println(restaurant.getName());
            restaurant.displayMenu();
        }

    }
}

