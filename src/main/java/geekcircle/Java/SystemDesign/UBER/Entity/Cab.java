package com.geekcircle.Java.SystemDesign.UBER.Entity;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Cab {

    private Location currentLocation;

    private Rider rider;

    private Boolean isAvailable;

    private Driver driver;

    public Cab(Driver driver) {
        this.driver = driver;
        this.isAvailable = true;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Cab setCurrentLatLong(Double lat, Double lng) {
        this.currentLocation = new Location(lat,lng);
        return this;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "currentLocation=" + currentLocation +
                ", rider=" + rider +
                ", isAvailable=" + isAvailable +
                ", driver=" + driver +
                '}';
    }
}
