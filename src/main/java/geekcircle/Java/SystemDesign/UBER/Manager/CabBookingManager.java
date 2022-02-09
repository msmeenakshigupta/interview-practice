package com.geekcircle.Java.SystemDesign.UBER.Manager;

import com.geekcircle.Java.SystemDesign.UBER.Entity.*;
import com.geekcircle.Java.SystemDesign.UBER.Services.CabService;
import com.geekcircle.Java.SystemDesign.UBER.Services.RiderService;

import java.util.List;

public class CabBookingManager {

    private Integer riderId;

    private Rider rider;

    private Location fromLocation;

    private Location toLocation;

    private RiderService riderService = new RiderService();

    private CabService cabService = new CabService();

    public CabBookingManager(Integer riderId, Location fromLocation, Location toLocation) {
        this.riderId = riderId;
        rider = riderService.findRiderById(riderId);
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Trip doBooking() {
        System.out.println("Book start process");
        Location ridersLocation = rider.getCurrentLocation();
        List<Cab> cabs = cabService.findCabNearby(ridersLocation);
        System.out.println(cabs.size()+" cabs found nearby");
        Cab selectedCab = cabService.selectionCriteria(cabs);
        System.out.println("Cab Selected : "+cabs);
        Double finalPrice = cabService.priceCalculator(selectedCab);
        System.out.println("Price Calculated Rs."+finalPrice);
        selectedCab.setAvailable(false);
        Trip trip = new Trip(fromLocation, toLocation, selectedCab, rider, finalPrice);
        System.out.println("Trip Booked");
        selectedCab.setRider(rider);
        System.out.println("Cab Information");
        System.out.println(selectedCab);
        //Save trip;
        return trip;
    }

    public boolean endTrip(Trip trip){
        trip.getCab().setAvailable(true);
        trip.setStatus(TripStatus.COMPLETED);
        System.out.println("Trip Ended");
        return true;
    }
}
