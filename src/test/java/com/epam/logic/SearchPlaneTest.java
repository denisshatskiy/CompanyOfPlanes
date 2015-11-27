package com.epam.logic;

import org.testng.annotations.Test;

public class SearchPlaneTest extends BaseForTests{

    @Test
    public void SearchPlane(){

        companyOfPlanes.searchByParameter();
    }
}
