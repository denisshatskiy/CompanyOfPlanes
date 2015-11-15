package com.epam;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Company company = input.inputFromFile();

        company.printPlaneList();
        company.printTotalCapacity();
        company.printTotalCarrying();
        company.printSortPlane();
        input.defineTopAndBottomLimits();
    }
}
