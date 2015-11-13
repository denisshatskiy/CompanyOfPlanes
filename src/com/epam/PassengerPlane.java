package com.epam;

public class PassengerPlane extends Plane {
    int seatsNumber;

    PassengerPlane(double car, double dist) {
        super(car, dist);
    }

    public void defineCapacity(){
        setCapacity(seatsNumber * 0.7);
    }

    public void setSeatsNumber(int seatsNumber){
        this.seatsNumber = seatsNumber;
    }
}
