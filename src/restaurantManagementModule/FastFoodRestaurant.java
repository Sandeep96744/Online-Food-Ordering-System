package restaurantManagementModule;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class FastFoodRestaurant extends Restaurant {
    private Map<String, Double> menu;


    public FastFoodRestaurant(String name, String cuisineType, String location, LocalTime closeTime, LocalTime openTime, boolean status) {
        super(name, cuisineType, location, closeTime, openTime, status);
        this.menu = new HashMap<>();
    }

    public Map<String, Double> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Double> menu) {
        this.menu = menu;
    }

    public void addMenuItem(String menuItem, Double price) {
        this.menu.put(menuItem, price);
    }

    public void displayMenu() {
        System.out.println("Welcome to " + this.getName() + ": A " + getClass().getSimpleName() + "!\nMenu Items:");
        for(String item: this.menu.keySet()) {
            System.out.printf("%-25s₹%-25s", item, menu.get(item));
            System.out.println();
        }
        System.out.println();
    }
}
