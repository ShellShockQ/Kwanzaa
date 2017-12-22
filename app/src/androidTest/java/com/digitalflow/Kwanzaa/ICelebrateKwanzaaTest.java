package com.digitalflow.Kwanzaa;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.digitalflow.Kwanzaa360.R;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Created by Detrick on 12/10/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ICelebrateKwanzaaTest {
    @Rule
    public IntentsTestRule<ICelebrateKwanzaa> mActivityRule =
            new IntentsTestRule<>(ICelebrateKwanzaa.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.digitalflow.Kwanzaa", appContext.getPackageName());
    }

    @Test
    public void WhenAddPersonButtonIsClickedCountUpdates() {
        //Assign
        int CurrentICelebrate = 9;
        String PREFS_NAME = "LocalSharedPreferences";
        String PREFS_KEY = "ICelebrateCount";
        int Mode = 0;
        SharedPreferences settings = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(PREFS_KEY, CurrentICelebrate);
        editor.commit();
        //    final ICelebrateKwanzaa activityUnderTest = mActivityRule.getActivity();
        //Act
        onView(withId(R.id.fab)).perform(click());
        int UpdatedCount = DataAccess.GetICelebrateCountFromSharedPreferences(PREFS_NAME, PREFS_KEY, Mode);
        //Assert
        Assert.assertEquals(CurrentICelebrate + 1, UpdatedCount);

    }

    @Test
    public void WhenupdateICelebrateCounterIsCalledTheCountUpdatesBy1() {
        //Assign
        int CurrentICelebrate = 9;
        String PREFS_NAME = "LocalSharedPreferences";
        String PREFS_KEY = "ICelebrateCount";
        int Mode = 0;
        SharedPreferences settings = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(PREFS_KEY, CurrentICelebrate);
        editor.commit();
        //Act
        int newICelebrateCount = ICelebrateKwanzaa.updateICelebrateCounter();
        //Assert
        Assert.assertEquals(CurrentICelebrate + 1, newICelebrateCount);

    }

    @Test
    public void WhenSampleTestIsPassedToGetStringFromSharedPreferenceItsWrittenCorrectly() {
        //Assign
        String PREFS_NAME = "TestPrefsFile";
        String StrTest = "The Is a Sample String";
        String PREFS_KEY = "TestString";
        int Mode = 0;
        SharedPreferences settings = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_KEY, StrTest);
        editor.commit();
//        //Act
        String resultingString = DataAccess.GetStringFromSharedPreferences(PREFS_NAME, PREFS_KEY, Mode);
        //Assert

        Assert.assertEquals(resultingString, StrTest);
    }

    @Test
    public void When7IsPassedToGetIntFromSharedPreferenceItsWrittenCorrectly() {
        //Assign
        String PREFS_NAME = "TestPrefsFile";
        int intTest = 7;
        String PREFS_KEY = "TestInt";
        int Mode = 0;
        SharedPreferences settings = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(PREFS_KEY, intTest);
        editor.commit();
//        //Act
        int resultingInteger = DataAccess.GetIntFromSharedPreferences(PREFS_NAME, PREFS_KEY, Mode);
        //Assert

        Assert.assertEquals(resultingInteger, intTest);
    }

    @Test
    public void WhenSharedPrefsAreClearedGetCurrentICelebrateCountReturnsZero() {
        //Assign
        String PREFS_NAME = "TestPrefsFile";
        String PREFS_KEY = "TestICelebrateCount";
        int Mode = 0;
        SharedPreferences settings = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(PREFS_KEY);
        editor.commit();
//        //Act
        int resultingInteger = DataAccess.GetICelebrateCountFromSharedPreferences(PREFS_NAME, PREFS_KEY, Mode);
        //Assert

        Assert.assertEquals(resultingInteger, 0);
    }

}