package com.digitalflow.Kwanzaa;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.digitalflow.testhelpers.EspressoTestsMatchers.hasDrawable;
import static com.digitalflow.testhelpers.EspressoTestsMatchers.withDrawable;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.digitalflow.Kwanzaa", appContext.getPackageName());
    }


    @Test
    public void When_DateIs_12_26_Of_ShowOneCandle() {
        final String sDateEntered = "12/26";
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        activityUnderTest.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityUnderTest.DisplayAppropriateImageBasedOnDate(sDateEntered);
            }
        });
        onView(withId(R.id.imgCandles)).check(matches(withDrawable(R.drawable.kwanzaa_day_01)));
        onView(withId(R.id.imgCandles)).check(matches(hasDrawable()));
    }

    @Test
    public void When_DateIs_12_25_ShowDaysUntilKwanzaaImage() {
        final String sDateEntered = "12/25";
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        activityUnderTest.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityUnderTest.DisplayAppropriateImageBasedOnDate(sDateEntered);
            }
        });
        onView(withId(R.id.imgCandles)).check(matches(withDrawable(R.drawable.dayuntil)));
        onView(withId(R.id.imgCandles)).check(matches(hasDrawable()));
    }

    @Test
    public void When_DateIs_12_20_ShowSixDaysUntilKwanzaa() {
        final String sDateEntered = "12/20";
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        activityUnderTest.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityUnderTest.DisplayAppropriateImageBasedOnDate(sDateEntered);
            }
        });
        onView(withId(R.id.daysUntilText)).check(matches(withText("6")));
        onView(withId(R.id.daysUntilText)).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    public void When_DateIs_12_1_ShowSixDaysUntilKwanzaa() {
        final String sDateEntered = "12/1";
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        activityUnderTest.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityUnderTest.DisplayAppropriateImageBasedOnDate(sDateEntered);
            }
        });
        onView(withId(R.id.daysUntilText)).check(matches(withText("25")));
    }

}
