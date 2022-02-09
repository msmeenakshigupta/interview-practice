package com.geekcircle.Java.SystemDesign.UBER.Entity;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-25
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class Trip {

    private Location from;

    private Location to;

    private Cab cab;

    private Rider rider;

    private Double price;

    private TripStatus status;

    public Trip(Location from, Location to, Cab cab, Rider rider, Double price) {
        this.from = from;
        this.to = to;
        this.cab = cab;
        this.rider = rider;
        this.price = price;
        this.status = TripStatus.ONGOING;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}
