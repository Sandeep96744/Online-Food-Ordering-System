package restaurantManagementModule;

import java.util.Map;

public class Order {
    int orderId;
    Customer customer;
    Map<MenuItem, Integer> cart;
    String address;
    String paymentType;

    public Order(int orderId, Customer customer, Map<MenuItem, Integer> cart, String address, String paymentType) {
        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
        this.address = address;
        this.paymentType = paymentType;
    }
}
