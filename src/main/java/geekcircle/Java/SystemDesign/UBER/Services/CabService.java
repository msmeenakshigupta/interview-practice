package com.geekcircle.Java.SystemDesign.UBER.Services;

import com.geekcircle.Java.SystemDesign.UBER.Entity.Cab;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Driver;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Location;

import java.util.ArrayList;
import java.util.List;

public class CabService {

    private final Integer searchDistance = 10;

    public List<Cab> findCabNearby(Location location){
        List<Cab> cabs = new ArrayList<>();
        cabs.add(new Cab(new Driver(1L, "Akshay", "8858886252")).setCurrentLatLong(10.00,11.00));
        return cabs;
    }

    public Cab selectionCriteria(List<Cab> cabs){
        if(cabs.size() == 0){
            return null;
        }
        return cabs.get(0);
    }

    public Double priceCalculator(Cab cab){
        return 143.98;
    }
}
