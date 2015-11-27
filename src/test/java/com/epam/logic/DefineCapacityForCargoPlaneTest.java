package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefineCapacityForCargoPlaneTest {

    @Test
    public void defineCapacityTest(){
        CargoPlane cargoPlane = new CargoPlane(150);
        cargoPlane.defineCapacity();
        double result = cargoPlane.getCapacity();
        Assert.assertEquals(result, 133.5, "Mistake in define capacity");
    }

    @Test(expectedExceptions = com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException.class)
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
