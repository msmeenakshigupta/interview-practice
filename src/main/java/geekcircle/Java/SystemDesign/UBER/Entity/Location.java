package com.geekcircle.Java.SystemDesign.UBER.Entity;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Location {

    private Double latitude;

    private Double longitude;

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double getDistance(Location location1, Location location2){
        double distance = 3963.0 * Math.acos((Math.sin(location1.latitude) * Math.sin(location2.latitude)) + Math.cos(location1.latitude) * Math.cos(location2.latitude) * Math.cos(location2.longitude - location1.longitude));
        return distance;
    }
}
