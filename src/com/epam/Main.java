package com.epam;

public class Main {

    public static void main(String[] args) {
        Input input = new Input();
        Company company = input.inputNumberOfSeats();

        company.printPlaneList();
        company.printTotalCapacity();
        company.printTotalCarrying();
        company.printSortPlane();
    }
}
