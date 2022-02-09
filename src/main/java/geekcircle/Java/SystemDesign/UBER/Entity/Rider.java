package com.geekcircle.Java.SystemDesign.UBER.Entity;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Rider {

    private String name;

    List<Trip> trips;

    Location currentLocation;

    public Rider(String name) {
        this.name = name;
        trips = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Trip trip) {
        this.trips.add(trip);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name='" + name + '\'' +
                ", trips=" + trips +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
