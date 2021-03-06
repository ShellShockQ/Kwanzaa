import com.digitalflow.Kwanzaa.DataAccess;
import com.digitalflow.Kwanzaa.KwanzaaDay;
import com.digitalflow.Kwanzaa360.R;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.digitalflow.Kwanzaa.DataAccess.GetListOfKwanzaaDays;

/**
 * Created by Detrick on 11/29/2017.
 */
public class DataAccessTest {

    @Test
    public void WhenCalledReturnTheDaysofKwanzaaImageEnglishSwahiliAndMeaning() {
        //Assign
        String theDate = "";
        List<KwanzaaDay> kwanzaaDaysList = new ArrayList<KwanzaaDay>();
        KwanzaaDay DayOne = new KwanzaaDay("12/26", "Umoja", "Unity", "To Strive for and maintain unity in the family, community, nation and race", R.drawable.kinaraday1, R.drawable.breadcrumb1226);
        KwanzaaDay DayTwo = new KwanzaaDay("12/27", "Kujichagulia", "Self-Determination", "To define ourselves, name ourselves, create for ourselves and speak for ourselves.", R.drawable.kinaraday2, R.drawable.breadcrumb1227);
        KwanzaaDay DayThree = new KwanzaaDay("12/28", "Ujima", "Collective Work and Responsibility", "To build and maintain our community", R.drawable.kinaraday3, R.drawable.breadcrumb1228);
        KwanzaaDay DayFour = new KwanzaaDay("12/29", "Ujamaa", "Cooperative Economics", "To build and maintain our own stores, shops and other businesses and to profit from them together", R.drawable.kinaraday4, R.drawable.breadcrumb1229);
        KwanzaaDay DayFive = new KwanzaaDay("12/30", "Nia", "Purpose", "To make our collective vocation the building and developing of our community in order to restoreout people to their traditional greatness.", R.drawable.kinaraday5, R.drawable.breadcrumb1230);
        KwanzaaDay DaySix = new KwanzaaDay("12/31", "Kuumba", "Creativity", "To do always as much as we can, in the way we can, in order to leave our community more beautiful and beneficial than we inherited it", R.drawable.kinaraday6, R.drawable.breadcrumb1231);
        KwanzaaDay DaySeven = new KwanzaaDay("1/1", "Imani", "Faith", "To believe with all our heart in our people, our parents, our teachers, our leaders and the righteousness and victory of our struggle", R.drawable.kinaraday7, R.drawable.breadcrumb0101);
        kwanzaaDaysList.add(DayOne);
        kwanzaaDaysList.add(DayTwo);
        kwanzaaDaysList.add(DayThree);
        kwanzaaDaysList.add(DayFour);
        kwanzaaDaysList.add(DayFive);
        kwanzaaDaysList.add(DaySix);
        kwanzaaDaysList.add(DaySeven);

        //Act
        List<KwanzaaDay> returnedKwanzaaDaysList = GetListOfKwanzaaDays(theDate);
        //Assert
        Assert.assertEquals(kwanzaaDaysList.get(0).theDate, returnedKwanzaaDaysList.get(0).theDate);
    }

    @Test
    public void WhenDateIs12_26KwanzaaImageEnglishSwahiliAndMeaning() {
        //Assign
        String theDate = "12/26";
        List<KwanzaaDay> kwanzaaDaysList = new ArrayList<KwanzaaDay>();
        KwanzaaDay DayOne = new KwanzaaDay("12/26", "Umoja", "Unity", "To Strive for and maintain unity in the family, community, nation and race", R.drawable.kinaraday1, R.drawable.breadcrumb1226);
        kwanzaaDaysList.add(DayOne);
        //Act
        List<KwanzaaDay> returnedKwanzaaDaysList = GetListOfKwanzaaDays(theDate);
        //Assert
        Assert.assertEquals(kwanzaaDaysList.get(0).EnglishName, returnedKwanzaaDaysList.get(0).EnglishName);
    }

    @Test
    public void WhenDateIs12_27KwanzaaImageEnglishSwahiliAndMeaning() {
        //Assign
        String theDate = "12/27";
        List<KwanzaaDay> kwanzaaDaysList = new ArrayList<KwanzaaDay>();
        KwanzaaDay DayTwo = new KwanzaaDay("12/27", "Kujichagulia", "Self-Determination", "To define ourselves, name ourselves, create for ourselves and speak for ourselves.", R.drawable.kinaraday2, R.drawable.breadcrumb1227);
        kwanzaaDaysList.add(DayTwo);
        //Act
        List<KwanzaaDay> returnedKwanzaaDaysList = GetListOfKwanzaaDays(theDate);
        //Assert
        Assert.assertEquals(kwanzaaDaysList.get(0).EnglishName, returnedKwanzaaDaysList.get(0).EnglishName);
    }

    @Test
    public void WhenDateIs1_1KwanzaaImageEnglishSwahiliAndMeaning() {
        //Assign
        String theDate = "1/1";
        List<KwanzaaDay> kwanzaaDaysList = new ArrayList<KwanzaaDay>();
        KwanzaaDay DaySeven = new KwanzaaDay("1/1", "Imani", "Faith", "To believe with all our heart in our people, our parents, our teachers, our leaders and the righteousness and victory of our struggle", R.drawable.kinaraday7, R.drawable.breadcrumb0101);
        kwanzaaDaysList.add(DaySeven);
        //Act
        List<KwanzaaDay> returnedKwanzaaDaysList = GetListOfKwanzaaDays(theDate);
        //Assert
        Assert.assertEquals(kwanzaaDaysList.get(0).EnglishName, returnedKwanzaaDaysList.get(0).EnglishName);
    }
    @Test
    public void WhenSampleDataICelebrateCountIsCalled12IsReturned() {
        //Assign
        int ExpectedCount = 12;
        //Act
        int ResultingCount = DataAccess.GetSampleDataICelebrateCount();
        //Assert
        Assert.assertEquals(ExpectedCount, ResultingCount);
    }

    @Test
    public void WhenGetICelebrateCountIsCalled12IsReturnedWhenAPIAvailableIsFalse() {
        //Assign
        int ExpectedCount = 12;
        Connection connection = null;
        //Act
        int ResultingCount = DataAccess.ICelebrateCount(connection);
        //Assert
        Assert.assertEquals(ExpectedCount, ResultingCount);
    }

    @Test
    public void WhenDateIsNullGetListOfKwanzaaDaysRecovers() {
        //Assign
        String theDate = null;
        List<KwanzaaDay> kwanzaaDaysList = new ArrayList<KwanzaaDay>();
        KwanzaaDay DayOne = new KwanzaaDay("12/26", "Umoja", "Unity", "To Strive for and maintain unity in the family, community, nation and race", R.drawable.kinaraday1, R.drawable.breadcrumb1226);
        KwanzaaDay DayTwo = new KwanzaaDay("12/27", "Kujichagulia", "Self-Determination", "To define ourselves, name ourselves, create for ourselves and speak for ourselves.", R.drawable.kinaraday2, R.drawable.breadcrumb1227);
        KwanzaaDay DayThree = new KwanzaaDay("12/28", "Ujima", "Collective Work and Responsibility", "To build and maintain our community", R.drawable.kinaraday3, R.drawable.breadcrumb1228);
        KwanzaaDay DayFour = new KwanzaaDay("12/29", "Ujamaa", "Cooperative Economics", "To build and maintain our own stores, shops and other businesses and to profit from them together", R.drawable.kinaraday4, R.drawable.breadcrumb1229);
        KwanzaaDay DayFive = new KwanzaaDay("12/30", "Nia", "Purpose", "To make our collective vocation the building and developing of our community in order to restoreout people to their traditional greatness.", R.drawable.kinaraday5, R.drawable.breadcrumb1230);
        KwanzaaDay DaySix = new KwanzaaDay("12/31", "Kuumba", "Creativity", "To do always as much as we can, in the way we can, in order to leave our community more beautiful and beneficial than we inherited it", R.drawable.kinaraday6, R.drawable.breadcrumb1231);
        KwanzaaDay DaySeven = new KwanzaaDay("1/1", "Imani", "Faith", "To believe with all our heart in our people, our parents, our teachers, our leaders and the righteousness and victory of our struggle", R.drawable.kinaraday7, R.drawable.breadcrumb0101);
        kwanzaaDaysList.add(DayOne);
        kwanzaaDaysList.add(DayTwo);
        kwanzaaDaysList.add(DayThree);
        kwanzaaDaysList.add(DayFour);
        kwanzaaDaysList.add(DayFive);
        kwanzaaDaysList.add(DaySix);
        kwanzaaDaysList.add(DaySeven);
        //Act
        List<KwanzaaDay> resultingList = GetListOfKwanzaaDays(theDate);
        //Assert
        Assert.assertEquals(kwanzaaDaysList.get(6).EnglishName, resultingList.get(6).EnglishName);
    }


}