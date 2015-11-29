package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class DefineTotalCapacityTest extends BaseForTests{

    @Test(description = "Define total capacity test", groups = "logic")
    public void defineTotalCapacity() throws NegativeValueException {
        companyOfPlanes.defineTotalCapacity();
        double result = companyOfPlanes.getTotalCapacity();
        Assert.assertEquals(result, 315D);
    }
}
