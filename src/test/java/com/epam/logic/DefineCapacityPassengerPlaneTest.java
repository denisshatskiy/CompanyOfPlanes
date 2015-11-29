package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefineCapacityPassengerPlaneTest {

    @Test(description = "Define total capacity for Passenger planes",
            groups = "logic")
    public void defineCapacityTest(){
        PassengerPlane passengerPlane = new PassengerPlane(150);
        passengerPlane.defineCapacity();
        double result = passengerPlane.getCapacity();
        Assert.assertEquals(result, 105D, "Mistake in define capacity");
    }

    @Test(description = "Check catching mistake with negative value in define total capacity for Cargo planes",
            expectedExceptions = NegativeValueException.class,
            groups = "logic", priority = 1)
    public void defineCapacityByNegativeValueTest(){
        PassengerPlane passengerPlane = new PassengerPlane(-150);
        passengerPlane.defineCapacity();
    }

    @Test(description = "Check catching mistake with zero value in define total capacity for Cargo planes",
            expectedExceptions = NumberFormatException.class,
            groups = "logic", priority = 2)
    public void defineCapacityByZeroTest(){
        PassengerPlane passengerPlane = new PassengerPlane(0);
        passengerPlane.defineCapacity();
    }
}
