package com.digitalflow.Kwanzaa;

import junit.framework.Assert;

import org.junit.Test;

import static com.digitalflow.Kwanzaa.icelebrate.GetCity;

/**
 * Created by Detrick on 12/10/2017.
 */
public class icelebrateTest {
    @Test
    public void GetTheCurrentCity() {
        //Arrange
        String myCity = "The Colony";
        //Act
        String resultCity = GetCity();

        //Assert
        Assert.assertEquals(resultCity, myCity);
    }
}