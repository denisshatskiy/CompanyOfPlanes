package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.IncorrectTypeOfPlaneException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DataReader {
    CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

    public CompanyOfPlanes inputManually() throws NegativeValueException, IncorrectTypeOfPlaneException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set the number of planes, which you want to input : ");
        int numberOfPlanes = scanner.nextInt();
        for (int i  = 0; i < numberOfPlanes; i ++) {
            System.out.println("Set the plane type \"P\" + or \"C\" : ");
            String planType= scanner.next();
            switch (planType){
                case "P" :{
                    System.out.println("Set next parameters with Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    PassengerPlane passengerPlane = new PassengerPlane(scanner.next(),
                            scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    passengerPlane.defineCapacity();
                    companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                    break;
                }
                case "C" :{
                    System.out.println("Set next parameters with Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    CargoPlane cargoPlane= new CargoPlane(scanner.next(),
                            scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    cargoPlane.defineCapacity();

                    companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                    break;
                }
                default:
                    throw new IncorrectTypeOfPlaneException();
            }
        }
        return companyOfPlanes;
    }

    public double[] inputTopAndBottomLimits() {
        Scanner scanner = new Scanner(System.in);
        double bottomParameter, topParameter;
        try {
            System.out.println("Set the bottom number for search :  ");
            bottomParameter = scanner.nextDouble();
            try {
                System.out.println("Set the top number for search : ");
                topParameter = scanner.nextDouble();
                try {
                    companyOfPlanes.searchByParameter(new double[]{bottomParameter, topParameter});
                    //return new double[]{bottomParameter, topParameter};
                } catch (NullPointerException e) {
                    System.out.println("There was null value");
                }
            } catch (InputMismatchException e) {
                System.out.println("There was a mismatch of types");
            }
        } catch (InputMismatchException e) {
            System.out.println("There was a mismatch of types");
        }finally {
            scanner.close();
        }
        return null;
    }
}
