package com.epam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {
    Company company = new Company();

    public Company inputNumberOfSeats(){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            System.out.println("Введите тип самолета P или C : ");
            String planType= scanner.next();
            switch (planType){
                case "P" :{
                    System.out.println("Введите данные через Enter (Carrying, Distance, NumberOfSeats) : ");
                    PassengerPlane passengerPlane = new PassengerPlane(scanner.nextDouble(), scanner.nextDouble());
                    passengerPlane.setSeatsNumber(scanner.nextInt());
                    passengerPlane.defineCapacity();

                    company.addPlanesToCompanyList(passengerPlane);
                    break;
                }
                case "C" :{
                    System.out.println("Введите данные через Enter (Carrying, Distance, NumberOfSeats) : ");
                    CargoPlane cargoPlane= new CargoPlane(scanner.nextDouble(), scanner.nextDouble());
                    cargoPlane.setBoxNumber(scanner.nextInt());
                    cargoPlane.defineCapacity();

                    company.addPlanesToCompanyList(cargoPlane);
                    break;
                }
            }
        }
        return company;
    }

   /* public Company inputFromFile() throws IOException {
        String fileName = "C://file.txt";
        BufferedReader read = null;
        try {
            read = new BufferedReader(new java.io.FileReader(fileName));
            String line;
            String tmpLine;
            String tmpNextLine = null;
            while ((line = read.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " : ");
                tmpLine = line.substring(0, line.indexOf(" : "));
                if (!tmpLine.equals(tmpNextLine)) {
                    tmpNextLine = tmpLine;
                    while (st.hasMoreTokens()) {
                        if (line.contains("Passenger")) {
                            st.nextToken();
                            PassengerPlane passengerPlane = new PassengerPlane(Double.valueOf(st.nextToken()), Double.valueOf(st.nextToken()));
                            passengerPlane.setSeatsNumber(Integer.valueOf(st.nextToken()));
                            company.addPlanesToCompanyList(passengerPlane);
                        }else if (line.contains("Cargo")){
                            st.nextToken();
                            CargoPlane cargoPlane = new CargoPlane(Double.valueOf(st.nextToken()),Double.valueOf(st.nextToken()));
                            cargoPlane.setBoxNumber(Integer.valueOf(st.nextToken()));
                            company.addPlanesToCompanyList(cargoPlane);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            read.close();
        }
        return company;
    }*/

    public void defineTopAndBottomLimits(){
        double bottomParametr, topParametr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите нижний параметр для поиска по дальности : ");
        bottomParametr = scanner.nextDouble();
        System.out.println("Введите верхний параметр для поиска по дальности : ");
        topParametr = scanner.nextDouble();

        company.searchByParametr(bottomParametr, topParametr);
    }
}
