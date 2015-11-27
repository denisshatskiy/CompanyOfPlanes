package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefineCapacityPassengerPlaneTest {

    @Test
    public void defineCapacityTest(){
        PassengerPlane passengerPlane = new PassengerPlane(150);
        passengerPlane.defineCapacity();
        double result = passengerPlane.getCapacity();
        Assert.assertEquals(result, 105D, "Mistake in define capacity");
    }

    @Test(expectedExceptions = NegativeValueException.class)
    public void defineCapacityByNegativeValueTest(){
        PassengerPlane passengerPlane = new PassengerPlane(-150);
        passengerPlane.defineCapacity();
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void defineCapacityByZeroTest(){
        PassengerPlane passengerPlane = new PassengerPlane(0);
        passengerPlane.defineCapacity();
    }
}
