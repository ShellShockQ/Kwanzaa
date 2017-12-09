package com.digitalflow.Kwanzaa;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.digitalflow.Kwanzaa360.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
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
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(
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

    @Test
    public void When_UserSwipes_MainActivityTheyGet_TheOverViewActivity() {
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        onView(withId(R.id.activity_main))
                .perform(swipeRight());
    }

    @Test
    public void When_LearnMoreButtonIsClickedGoToTheViewPager() {
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        onView(withId(R.id.LearnMoreButton)).perform(click());
        intended(hasComponent(KwanzaaViewPager.class.getName()));

    }

    @Test
    public void When_MenuIsClickedAMenuNavigationDrawerIsShown() {
        final MainActivity activityUnderTest = mActivityRule.getActivity();
        onView(withId(R.id.navigationdrawermenu)).perform(click());
        onView(withId(R.id.navigationdrawer_layout)).check(matches(isOpen()));

    }

}
