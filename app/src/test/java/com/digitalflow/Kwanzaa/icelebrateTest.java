package com.digitalflow.Kwanzaa;

import junit.framework.Assert;

import org.junit.Test;

import static com.digitalflow.Kwanzaa.icelebrate.GetCelebatorCountInCity;
import static com.digitalflow.Kwanzaa.icelebrate.GetCity;

/**
 * Created by Detrick on 12/10/2017.
 */
public class icelebrateTest {
    @Test
    public void WhenLongLatGivenTheCurrentCityIsTheColony() {
        //Arrange
        String myCity = "The Colony";
        double lon = 33.0806;
        double lat = 96.8928;
        //Act
        String resultCity = GetCity();

        //Assert
        Assert.assertEquals(resultCity, myCity);
    }

    @Test
    public void WhenGivenTheNorthPoleZeroCountIsReturned() {
        //Arrange
        String myCity = "The North Pole";
        double lon = 90;
        double lat = 0;
        //Act
        int resultCount = GetCelebatorCountInCity();

        //Assert
        Assert.assertEquals(0, resultCount);


    }


}