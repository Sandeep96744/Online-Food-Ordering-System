package restaurantManagementModule;

import java.time.LocalTime;

public class Restaurant {
    private String name;
    private String cuisineType;
    private String location;
    private LocalTime openTime;
    private LocalTime closeTime;
    private boolean status;

    public Restaurant(String name, String cuisineType, String location, LocalTime openTime, LocalTime closeTime, boolean status) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.location = location;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Restaurant:\n" +
                "name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", location='" + location + '\'' +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", status=" + ((status)?"Active\n": "Inactive\n");
    }
}
