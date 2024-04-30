package restaurantManagementModule;

import java.time.LocalTime;

public class Admin {
    public static void main(String[] args) {

        FastFoodRestaurant restaurant1 = new FastFoodRestaurant("BiggBoss", "Chinese", "Kolkata",
                LocalTime.parse("09:00"), LocalTime.parse("19:00"), true);

        restaurant1.addMenuItem("Noodles", 149.0);
        restaurant1.addMenuItem("Soup", 119.0);
        restaurant1.addMenuItem("Manchurian", 349.0);

        restaurant1.displayMenu();

        System.out.println(restaurant1);



        FineDiningRestaurant restaurant2 = new FineDiningRestaurant("Sanjha Chulha", "Indian", "Kolkata",
                LocalTime.parse("09:00"), LocalTime.parse("20:00"), true);

        restaurant2.addMenuItem("Chicken Biryani", 399.0);
        restaurant2.addMenuItem("Kadhai Paneer", 249.0);
        restaurant2.addMenuItem("Butter Naan", 25.0);

        restaurant2.displayMenu();
    }
}

