package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.customException.NegativeValueException;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class DefineTotalCapacityTest extends BaseForTests{

    @Test
    public void defineTotalCapacity() throws NegativeValueException {
        companyOfPlanes.defineTotalCapacity();
        double result = companyOfPlanes.getTotalCapacity();
        Assert.assertEquals(result, 315D);
    }
}
