package com.digitalflow.Kwanzaa;

import android.app.Activity;
import android.content.SharedPreferences;

import com.digitalflow.Kwanzaa360.R;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Detrick on 11/29/2017.
 */

public class DataAccess extends Activity {


    public static List<KwanzaaDay> GetListOfKwanzaaDays() {
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
        return kwanzaaDaysList;
    }

    public static List<NavigationDrawerItem> getMenuItems() {
        List<NavigationDrawerItem> MenuItemList = new ArrayList<NavigationDrawerItem>();
        NavigationDrawerItem item1 = new NavigationDrawerItem("YesI Celebrate Kwanzaa",
                R.drawable.dayuntil);
        MenuItemList.add(item1);
        return MenuItemList;
    }

    public static int GetSampleDataICelebrateCount() {
        return 12;
    }

    public static int ICelebrateCount(Connection connection) {
        int count = GetSampleDataICelebrateCount();
        if (connection != null) count = GetICelebrateCountFromAPI();

        return count;
    }

    private static int GetICelebrateCountFromAPI() {
        throw new java.lang.UnsupportedOperationException();
    }


    public static void WriteStringToSharedPreferences(String PREFS_NAME, String prefs_key, int Mode, String sValue) {
        SharedPreferences preferences = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, Mode);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(prefs_key, sValue);
        editor.commit();
    }

    public static void WriteIntToSharedPreferences(String PREFS_NAME, String prefs_key, int Mode, int sValue) {
        SharedPreferences preferences = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, Mode);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(prefs_key, sValue);
        editor.commit();
    }

    public static String GetStringFromSharedPreferences(String PREFS_NAME, String PREFS_KEY, int Mode) {
        SharedPreferences preferences = Kwanzaa360.getAppContext().getSharedPreferences(PREFS_NAME, Mode);
        return preferences.getString(PREFS_KEY, "");

    }

    public static int GetIntFromSharedPreferences(String prefs_name, String PREFS_KEY, int mode) {
        SharedPreferences preferences = Kwanzaa360.getAppContext().getSharedPreferences(prefs_name, mode);
        return preferences.getInt(PREFS_KEY, 0);

    }

    public static int GetICelebrateCountFromSharedPreferences(String prefs_name, String prefs_key, int mode) {
        SharedPreferences preferences = Kwanzaa360.getAppContext().getSharedPreferences(prefs_name, mode);
        return preferences.getInt(prefs_key, 0);

    }
}
