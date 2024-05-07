package restaurantManagementModule;

import java.util.Map;

public class Order {
    Customer customer;
    Map<MenuItem, Integer> cart;
    String address;
    String paymentType;

    public Order(Customer customer, Map<MenuItem, Integer> cart, String address, String paymentType) {
        this.customer = customer;
        this.cart = cart;
        this.address = address;
        this.paymentType = paymentType;
    }
}
