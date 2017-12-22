package com.digitalflow.Kwanzaa;

import android.app.Application;
import android.content.Context;

/**
 * Created by Detrick on 12/22/2017.
 */

public class Kwanzaa360 extends Application {
    private static Context context;

    public static Context getAppContext() {
        return Kwanzaa360.context;
    }

    public void onCreate() {
        super.onCreate();
        Kwanzaa360.context = getApplicationContext();
    }

}
