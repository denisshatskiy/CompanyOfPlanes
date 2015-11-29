package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.CargoPlane;
import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefineCapacityForCargoPlaneTest {

    @Test(description = "Define total capacity for Cargo planes", groups = "logic")
    public void defineCapacityTest(){
        CargoPlane cargoPlane = new CargoPlane(150);
        cargoPlane.defineCapacity();
        double result = cargoPlane.getCapacity();
        Assert.assertEquals(result, 133.5, "Mistake in define capacity");
    }

    @Test(description = "Check catching mistake with negative value in define total capacity for Cargo planes",
            expectedExceptions = com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException.class,
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
