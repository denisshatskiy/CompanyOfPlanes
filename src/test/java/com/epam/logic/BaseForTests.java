package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CompanyOfPlanes;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.testng.annotations.BeforeClass;

public class BaseForTests {
    CompanyOfPlanes companyOfPlanes = new CompanyOfPlanes();
    @BeforeClass
    public void BaseForTest() throws NegativeValueException {

        for (int i = 0; i < 3; i ++) {
            PassengerPlane passengerPlane = new PassengerPlane("Plane", 12D, 12D, 150);
            companyOfPlanes.addPlanesToCompanyList(passengerPlane);
        }
    }
}
