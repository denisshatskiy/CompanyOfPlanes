package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileReader {
    CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

    public CompanyOfPlanes inputManually() throws NegativeValueException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i ++) {
            System.out.println("¬ведите тип самолета P или C : ");
            String planType= scanner.next();
            switch (planType){
                case "P" :{
                    System.out.println("¬ведите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    PassengerPlane passengerPlane = new PassengerPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    passengerPlane.defineCapacity();
                    companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                    break;
                }
                case "C" :{
                    System.out.println("¬ведите данные через Enter (Name, Carrying, Distance, NumberOfSeats) : ");
                    CargoPlane cargoPlane= new CargoPlane(scanner.next(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                    cargoPlane.defineCapacity();

                    companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                    break;
                }
            }
        }
        return companyOfPlanes;
    }

    public CompanyOfPlanes inputFromFile() throws IOException, NegativeValueException {
        File inputFile = new File("inputFile.txt");
        try {
            BufferedReader read = new BufferedReader(new java.io.FileReader(inputFile));
            String line;
            //if (!(inputFile.length() == 0)) {
            while ((line = read.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, " : ");
                while (stringTokenizer.hasMoreElements()) {
                    if (line.contains("P")) {
                        try {
                            stringTokenizer.nextElement();
                            PassengerPlane passengerPlane = new PassengerPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()), Integer.valueOf(stringTokenizer.nextToken()));
                            companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : line (" + line + ") won't be added to list!");
                        }
                    } else if (line.contains("C")) {
                        try {
                            stringTokenizer.nextElement();
                            CargoPlane cargoPlane = new CargoPlane(stringTokenizer.nextToken(), Double.valueOf(stringTokenizer.nextToken()), Double.valueOf(stringTokenizer.nextToken()), Integer.valueOf(stringTokenizer.nextToken()));
                            companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : line (" + line + ") won't be added to list!");
                        }
                    }
                }
            }
            read.close();
            return companyOfPlanes;
        }catch (NullPointerException e) {
            System.out.println("File is empty");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return null;
    }

    public double[] inputTopAndBottomLimits(){
        double bottomParameter, topParameter;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Set the bottom number for search :  ");
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

    public CompanyOfPlanes readFromXML(){
        try {
            File inputFile = new File("inputFile.txt");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("plane");
            for (int temp = 0; temp < nodeList.getLength(); temp ++){
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getAttribute("planeType").contains("P")) {
                        try {
                            PassengerPlane passengerPlane = new PassengerPlane(element.getElementsByTagName("name").item(0).getTextContent(),
                                    Double.valueOf(element.getElementsByTagName("carrying").item(0).getTextContent()),
                                    Double.valueOf(element.getElementsByTagName("distance").item(0).getTextContent()),
                                    Integer.valueOf(element.getElementsByTagName("seatsNumber").item(0).getTextContent()));
                            companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane  (" + element.getElementsByTagName("name").item(0).getTextContent() + ") won't be added to list!");
                        }
                    } else if (element.getAttribute("planeType").contains("C")) {
                        try {
                            CargoPlane cargoPlane = new CargoPlane(element.getElementsByTagName("name").item(0).getTextContent(),
                                    Double.valueOf(element.getElementsByTagName("carrying").item(0).getTextContent()),
                                    Double.valueOf(element.getElementsByTagName("distance").item(0).getTextContent()),
                                    Integer.valueOf(element.getElementsByTagName("boxNumber").item(0).getTextContent()));
                            companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane (" + element.getElementsByTagName("name").item(0).getTextContent() + ") won't be added to list!");
                        }
                    }
                }
            }
            return companyOfPlanes;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public CompanyOfPlanes readFromDatabase() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "test", "test");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            Statement stmt = null;
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANYOFPLANES");
                while (rs.next()) {
                    String planeType = rs.getString("PLANETYPE");
                    String planeName = rs.getString("NAME");
                    double carrying = rs.getDouble("CARRYING");
                    double distance = rs.getDouble("DISTANCE");
                    int freeSpaceNumber = rs.getInt("FREESPACENUMBER");

                    if (planeType.contains("P")) {
                        try {
                            PassengerPlane passengerPlane = new PassengerPlane(planeName, Double.valueOf(carrying),
                                    Double.valueOf(distance), Integer.valueOf(freeSpaceNumber));
                            companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane  (" + planeName + ") won't be added to list!");
                        } catch (NegativeValueException e) {
                            e.printStackTrace();
                        }
                    } else if (planeType.contains("C")) {
                        try {
                            CargoPlane cargoPlane = new CargoPlane(planeName, Double.valueOf(carrying),
                                    Double.valueOf(distance), Integer.valueOf(freeSpaceNumber));
                            companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane (" + planeName + ") won't be added to list!");
                        }
                    }
                }
                return companyOfPlanes;
            } catch (SQLException e ) {
                System.out.print("Error!");
            } finally {
                if (stmt != null) { stmt.close(); }
            }
        } else {
            System.out.println("Failed to make connection!");
        }
        return null;
    }
}
