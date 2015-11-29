package com.epam.logic;

import com.epam.mentoringProgram.lesson4.companyOfPlanes.subject.Plane;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class SearchPlaneTest extends BaseForTests{

    @Test(description = "Check that search by parameter is working", groups = "Boolean")
    public void SearchPlane(){
        companyOfPlanes.searchByParameter(new double[]{10D, 1000D});
        for (Plane plane : companyOfPlanes.getResultOfSearch())
        Assert.assertTrue(plane.getDistance()>=10D && plane.getDistance()<=1000D);
    }
}
