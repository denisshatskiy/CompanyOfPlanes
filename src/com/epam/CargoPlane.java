package com.epam;

public class CargoPlane extends Plane {
    int boxNumber;

    CargoPlane(double car, double dist) {
        super(car, dist);
    }

    public void defineCapacity() {
        setCapacity(boxNumber * 0.89);
    }

    public void setBoxNumber(int boxNumber){
        this.boxNumber = boxNumber;
    }
}
