package com.epam;

import java.text.NumberFormat;

abstract class Plane{
    private String name;
    private Double carrying;
    private Double capacity;
    private Double distance;

    Plane(String  name, double carrying, double distance){
        this.name = name;
        this.carrying = carrying;
        this.distance = distance;
    }

    NumberFormat formatter = NumberFormat.getNumberInstance();

    public String getName(){
        return name;
    }

    public void setName (String name){
        this.name = name;
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
        return (name + " - carrying: " + formatter.format(carrying) + " , capacity: " + formatter.format(capacity) + " , distance: " + formatter.format(distance));
    }
}