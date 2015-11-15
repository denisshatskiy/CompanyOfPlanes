package com.epam;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new Input();
        Writer writer = new Writer();
        Company company = input.inputFromFile();

        writer.createFile();
        company.printPlaneList();
        company.printTotalCapacity();
        company.printTotalCarrying();
        company.printSortPlane();
        input.defineTopAndBottomLimits();

    }
}
