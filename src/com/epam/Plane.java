package com.epam;

abstract class Plane{
    private Double carrying;
    private Double capacity;
    private Double distance;

    Plane(double car, double dist){
        carrying = car;
        distance = dist;
    }

    public double getCarrying(){
        return carrying;
    }

    public abstract void defineCapacity();

    public void setCapacity(double capacity){
        this.capacity = capacity;
    }

    public double getCapacity(){
        return capacity;
    }

    public double getDistance(){
        return distance;
    }

    public String toString(){
        return ("Carrying : " + carrying + " capacity : " + capacity + " distance : " + distance);
    }
}