package com.geekcircle.Java.SystemDesign;

import com.geekcircle.Java.SystemDesign.UBER.Entity.Cab;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Driver;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Location;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Rider;

import java.util.ArrayList;
import java.util.List;

public class CabBookingManager {

    private final Integer searchDistance = 10;

    private Rider rider;

    public CabBookingManager(Rider rider) {
        this.rider = rider;
    }

    boolean doBooking(){
        Location ridersLocation = rider.getCurrentLocation();
        List<Cab> cabs = findCanNearby(ridersLocation);
        Cab selectedCab = selectionCriteria(cabs);
        return true;
    }

    List<Cab> findCanNearby(Location location){
        List<Cab> cabs = new ArrayList<>();
        cabs.add(new Cab(new Driver(1L, "Akshay", "8858886252")).setCurrentLatLong(10.00,11.00));
        return cabs;
    }

    Cab selectionCriteria(List<Cab> cabs){
        if(cabs.size() == 0){
            return null;
        }
        return cabs.get(0);
    }
}
