package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
    CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

    public CompanyOfPlanes inputManually(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            System.out.println("¬ведите тип самолета P или C : ");
            String planType= scanner.next();
            switch (planType){
                case "P" :{
                    System.out.println("¬ведите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    PassengerPlane passengerPlane = new PassengerPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    passengerPlane.setSeatsNumber(scanner.nextInt());
                    passengerPlane.defineCapacity();

                    companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                    break;
                }
                case "C" :{
                    System.out.println("¬ведите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    CargoPlane cargoPlane= new CargoPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    cargoPlane.setBoxNumber(scanner.nextInt());
                    cargoPlane.defineCapacity();

                    companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                    break;
                }
            }
        }
        return companyOfPlanes;
    }

    public CompanyOfPlanes inputFromFile() throws IOException {
        File inputFile = new File("inputFile.txt");
        try {
            BufferedReader read = new BufferedReader(new java.io.FileReader(inputFile));
            String line;
            if (!(inputFile.length() == 0)) {
                while ((line = read.readLine()) != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(line, " : ");
                    while (stringTokenizer.hasMoreElements()) {
                        if (line.contains("P")) {
                            try {
                                stringTokenizer.nextElement();
                                PassengerPlane passengerPlane = new PassengerPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()));
                                passengerPlane.setSeatsNumber(Integer.valueOf(stringTokenizer.nextToken()));
                                passengerPlane.defineCapacity();
                                companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter");
                            }
                        } else if (line.contains("C")) {
                            try {
                                stringTokenizer.nextElement();
                                CargoPlane cargoPlane = new CargoPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()));
                                cargoPlane.setBoxNumber(Integer.valueOf(stringTokenizer.nextToken()));
                                cargoPlane.defineCapacity();
                                companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                            } catch (NumberFormatException e) {
                                System.out.println("There was an invalid parameter");
                            }
                        }
                    }
                }
                read.close();
                return companyOfPlanes;
            } else{
                System.out.print("File is empty");
                System.exit(-1);
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(-1);
        }
        return null;
    }

    public double[] inputTopAndBottomLimits(){
        double bottomParameter = 0, topParameter = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nSet the bottom number for search : ");
            bottomParameter = scanner.nextDouble();
            try {
                System.out.println("Set the top number for search : ");
                topParameter = scanner.nextDouble();
                try {
                    return new double[]{bottomParameter, topParameter};
                }
                catch (NullPointerException e){
                    System.out.println("There was null value");
                }
            }
            catch (InputMismatchException e){
                System.out.println("There was a mismatch of types");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("There was a mismatch of types");
        }

        return null;
    }
}
