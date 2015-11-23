package com.epam.mentoringProgram.lesson4.companyOfPlanes.core;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.FileIsEmptyException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;

import java.sql.*;

public class DBReader extends DataReaderFromSource {
    @Override
    public CompanyOfPlanes readData() throws FileIsEmptyException, SQLException {

        setSourceName("jdbc:oracle:thin:@EPKZKARW0456:1521/XE");

        CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(getSourceName(), "test", "test");
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
                            PassengerPlane passengerPlane = new PassengerPlane(planeName, carrying,
                                    distance, freeSpaceNumber);
                            companyOfPlanes.addPlanesToCompanyList(passengerPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane  ("
                                    + planeName + ") won't be added to list!");
                        } catch (NegativeValueException e) {
                            e.printStackTrace();
                        }
                    } else if (planeType.contains("C")) {
                        try {
                            CargoPlane cargoPlane = new CargoPlane(planeName, carrying,
                                    distance, freeSpaceNumber);
                            companyOfPlanes.addPlanesToCompanyList(cargoPlane);
                        } catch (NumberFormatException e) {
                            System.out.println("There was an invalid parameter : plane ("
                                    + planeName + ") won't be added to list!");
                        } catch (NegativeValueException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return companyOfPlanes;
            }
            catch (SQLException e ) {
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
