package repository;

import restaurantManagementModule.Restaurant;
import util.JdbcConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Optional;


public class RestaurantDatabaseRepositoryImpl implements RestaurantDatabaseRepository {

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) throws SQLException {
        try(Connection connection = JdbcConnectionUtil.getConnection()) {
            String query = "insert into restaurant values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, restaurant.getId());
            stm.setString(2, restaurant.getName());
            stm.setString(3, String.valueOf(restaurant.getCuisineType()));
            stm.setString(4, restaurant.getLocation());
            stm.setTime(5, Time.valueOf(restaurant.getOpenTime()));
            stm.setTime(6, Time.valueOf(restaurant.getCloseTime()));
            stm.setBoolean(7, restaurant.isActive());

            if(stm.executeUpdate() == 0)
                throw new RuntimeException("Unable to Insert!");
            return restaurant;
        }
        catch (SQLException ex) { throw new RuntimeException(ex.getMessage()); }
    }

    @Override
    public Optional<Restaurant> getRestaurantById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> getRestaurantByLocation(String location) {
        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> getRestaurantByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return List.of();
    }

    @Override
    public List<Restaurant> getAllActiveRestaurants() {
        return List.of();
    }

    @Override
    public List<Restaurant> getAllDeActiveRestaurants() {
        return List.of();
    }

    @Override
    public Optional<Restaurant> updateActivationStatus(Restaurant restaurant) {
        return Optional.empty();
    }

    @Override
    public Optional<Restaurant> deleteRestaurant(int id) {
        return Optional.empty();
    }
}
