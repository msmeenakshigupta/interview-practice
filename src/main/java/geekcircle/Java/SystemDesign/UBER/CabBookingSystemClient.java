package com.geekcircle.Java.SystemDesign.UBER;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import com.geekcircle.Java.SystemDesign.UBER.Entity.Location;
import com.geekcircle.Java.SystemDesign.UBER.Entity.Trip;
import com.geekcircle.Java.SystemDesign.UBER.Manager.CabBookingManager;

public class CabBookingSystemClient {
    public static void main(String[] args) {
        CabBookingManager cabBookingManager = new CabBookingManager(1, new Location(10.0, 11.0), new Location(10.0, 11.0));
        Trip trip = cabBookingManager.doBooking();
        cabBookingManager.endTrip(trip);
    }
}
