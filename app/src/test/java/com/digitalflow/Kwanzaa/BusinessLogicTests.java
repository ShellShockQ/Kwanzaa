package com.digitalflow.Kwanzaa;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BusinessLogicTests {
    final private BusinessLogic logic = new BusinessLogic();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void When_DateIs_12_26_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsUmoja() {
        //Assign
        String sDateEntered = "12/26";
        String sKwanzaaDayInSwahili = "Umoja";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_27_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsKujichagulia() {
        //Assign
        String sDateEntered = "12/27";
        String sKwanzaaDayInSwahili = "Kujichagulia";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_28_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsUjima() {
        //Assign
        String sDateEntered = "12/28";
        String sKwanzaaDayInSwahili = "Ujima";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_29_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsUjamaa() {
        //Assign
        String sDateEntered = "12/29";
        String sKwanzaaDayInSwahili = "Ujamaa";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_30_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsNia() {
        //Assign
        String sDateEntered = "12/30";
        String sKwanzaaDayInSwahili = "Nia";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_31_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsKuumba() {
        //Assign
        String sDateEntered = "12/31";
        String sKwanzaaDayInSwahili = "Kuumba";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_1_1_Of_WhichDayOfKwanzaaIsItInSwahiliReturnsImani() {
        //Assign
        String sDateEntered = "1/1";
        String sKwanzaaDayInSwahili = "Nia";
        //Act
        String SwahiliDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        //Assert
        Assert.assertEquals(SwahiliDayOfKwanzaa, sKwanzaaDayInSwahili);

    }

    @Test
    public void When_DateIs_12_26_Of_WhichDayOfKwanzaaIsItInEnglishReturnsUnity() {
        //Assign
        String sDateEntered = "12/26";
        String sKwanzaaDayInEnglish = "Unity";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_12_27_Of_WhichDayOfKwanzaaIsItInEnglishReturnsSelfDetermination() {
        //Assign
        String sDateEntered = "12/27";
        String sKwanzaaDayInEnglish = "Self Determination";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_12_28_Of_WhichDayOfKwanzaaIsItInEnglishReturnsCollectiveWork() {
        //Assign
        String sDateEntered = "12/28";
        String sKwanzaaDayInEnglish = "Collective Work and Responsibility";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_12_29_Of_WhichDayOfKwanzaaIsItInEnglishReturnsCollectiveEconomics() {
        //Assign
        String sDateEntered = "12/29";
        String sKwanzaaDayInEnglish = "Collective Economics";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_12_30_Of_WhichDayOfKwanzaaIsItInEnglishReturnsPurpose() {
        //Assign
        String sDateEntered = "12/30";
        String sKwanzaaDayInEnglish = "Purpose";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_12_31_Of_WhichDayOfKwanzaaIsItInEnglishReturnsCreativity() {
        //Assign
        String sDateEntered = "12/31";
        String sKwanzaaDayInEnglish = "Creativity";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_1_1_Of_WhichDayOfKwanzaaIsItInEnglishReturnsPurpose() {
        //Assign
        String sDateEntered = "1/1";
        String sKwanzaaDayInEnglish = "Purpose";
        //Act
        String EnglishDayOfKwanzaa = logic.WhichDayOfKwanzaaIsItInEnglish(sDateEntered);
        //Assert
        Assert.assertEquals(EnglishDayOfKwanzaa, sKwanzaaDayInEnglish);

    }

    @Test
    public void When_DateIs_1_2_IsAKwanzaaDayReturnsFalse() {
        //Assign
        String sDateEntered = "1/2";
        //Act
        boolean isItAKwanzaaDay = logic.isAKWANZAAday(sDateEntered);
        //Assert
        Assert.assertFalse("1/2 is not a KwanzaaDay", isItAKwanzaaDay);

    }

    @Test
    public void When_DateIs_12_28_IsAKwanzaaDayReturnsTrue() {
        //Assign
        String sDateEntered = "12/28";
        //Act
        boolean isItAKwanzaaDay = logic.isAKWANZAAday(sDateEntered);
        //Assert
        Assert.assertTrue("12/22 is a KwanzaaDay", isItAKwanzaaDay);

    }

    @Test
    public void When_DateIs_12_25_DaysUntilKwanzaaReturnsOne() {
        //Assign
        String sDateEntered = "12/25";
        //Act
        int daysUntilKwanzaa = logic.daysUntilKwanzaa(sDateEntered);
        //Assert
        Assert.assertEquals(1, daysUntilKwanzaa);

    }

    @Test
    public void When_DateIs_12_1_DaysUntilKwanzaaReturns25() {
        //Assign
        String sDateEntered = "12/1";
        //Act
        int daysUntilKwanzaa = logic.daysUntilKwanzaa(sDateEntered);
        //Assert
        Assert.assertEquals(25, daysUntilKwanzaa);

    }

    @Test
    public void When_DateIs_12_26_DaysUntilKwanzaaReturns0() {
        //Assign
        String sDateEntered = "12/26";
        //Act
        int daysUntilKwanzaa = logic.daysUntilKwanzaa(sDateEntered);
        //Assert
        Assert.assertEquals(0, daysUntilKwanzaa);

    }

    @Test
    public void When_DateIs_1_1_DaysUntilKwanzaaReturns0() {
        //Assign
        String sDateEntered = "1/1";
        //Act
        int daysUntilKwanzaa = logic.daysUntilKwanzaa(sDateEntered);
        //Assert
        Assert.assertEquals(0, daysUntilKwanzaa);

    }

    @Test
    public void When_DateIs_1_2_DaysUntilKwanzaaReturns() {
        //Assign
        String sDateEntered = "1/2";
        //Act
        int daysUntilKwanzaa = logic.daysUntilKwanzaa(sDateEntered);
        //Assert
        Assert.assertEquals(358, daysUntilKwanzaa);

    }

    @Test
    public void WhenStringAddressIsGivenToGetCityFromLocationStringTheColonyReturned() {
        //Arrange
        String theLocation = "Address[addressLines=[0:\"5613 Overland Dr, The Colony, TX 75056, USA\"],feature=5613,admin=Texas,sub-admin=Denton County,locality=The Colony,thoroughfare=Overland Drive,postalCode=75056,countryCode=US,countryName=United States,hasLatitude=true,latitude=33.0910765,hasLongitude=true,longitude=-96.8697442,phone=null,url=null,extras=null]";
        //Act
        //  String theCity = getCityFromLocationString(theLocation);
        //Assert


    }

}