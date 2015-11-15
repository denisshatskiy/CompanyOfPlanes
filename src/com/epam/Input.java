package com.epam;

import java.io.*;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
    Company company = new Company();

    public Company inputManually(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            System.out.println("Введите тип самолета P или C : ");
            String planType= scanner.next();
            switch (planType){
                case "P" :{
                    System.out.println("Введите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    PassengerPlane passengerPlane = new PassengerPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    passengerPlane.setSeatsNumber(scanner.nextInt());
                    passengerPlane.defineCapacity();

                    company.addPlanesToCompanyList(passengerPlane);
                    break;
                }
                case "C" :{
                    System.out.println("Введите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    CargoPlane cargoPlane= new CargoPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    cargoPlane.setBoxNumber(scanner.nextInt());
                    cargoPlane.defineCapacity();

                    company.addPlanesToCompanyList(cargoPlane);
                    break;
                }
            }
        }
        return company;
    }

    public Company inputFromFile() throws IOException {
        File inputFile = new File("D:\\file.txt");
        try {
            BufferedReader read  = new BufferedReader(new java.io.FileReader(inputFile));
            String line;
            while ((line = read.readLine())!= null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, " : ");
                while (stringTokenizer.hasMoreElements()) {
                    if (line.contains("P")) {
                        stringTokenizer.nextElement();
                        PassengerPlane passengerPlane = new PassengerPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()));
                        passengerPlane.setSeatsNumber(Integer.valueOf(stringTokenizer.nextToken()));
                        passengerPlane.defineCapacity();
                        company.addPlanesToCompanyList(passengerPlane);
                    } else if (line.contains("C")) {
                        stringTokenizer.nextElement();
                        CargoPlane cargoPlane = new CargoPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()));
                        cargoPlane.setBoxNumber(Integer.valueOf(stringTokenizer.nextToken()));
                        cargoPlane.defineCapacity();
                        company.addPlanesToCompanyList(cargoPlane);
                    }
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void defineTopAndBottomLimits(){
        double bottomParametr, topParametr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSet the bottom number for search : ");
        bottomParametr = scanner.nextDouble();
        System.out.println("Set the top number for search : ");
        topParametr = scanner.nextDouble();

        company.searchByParametr(bottomParametr, topParametr);
    }
}
