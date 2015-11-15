package com.epam;

public class PassengerPlane extends Plane {
    int seatsNumber;

    PassengerPlane(String name, double carrying, double distance) {
        super(name, carrying, distance);
    }

    public void defineCapacity(){
        setCapacity(seatsNumber * 0.7);
    }

    public void setSeatsNumber(int seatsNumber){
        this.seatsNumber = seatsNumber;
    }
}
