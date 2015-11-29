package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class DefineTotalCarryingTest extends BaseForTests{

    @Test(description = "Define total carrying test", groups = "logic")
    public void defineTotalCarrying() throws NegativeValueException {
        companyOfPlanes.defineTotalCarrying();
        double result = companyOfPlanes.getTotalCarrying();
        Assert.assertEquals(result, 36D);

    }
}