package com.digitalflow.Kwanzaa;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Detrick on 12/24/2017.
 */

public class NotificationReciever extends BroadcastReceiver {
    public boolean alarmUp = (PendingIntent.getBroadcast(Kwanzaa360.getAppContext(), 0,
            new Intent("com.digitalflow.Kwanzaa.NotificationReciever"),
            PendingIntent.FLAG_NO_CREATE) != null);
    String theDate = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        BusinessLogic businessLogic = new BusinessLogic();
        try {
            theDate = BusinessLogic.getDateAsAString();
            businessLogic.KwanzaaNotify(theDate);
            if (BusinessLogic.isAKWANZAAday(theDate) && (alarmUp)) {
                BusinessLogic.setupAlarmManager();
            }
        } catch (Exception ex) {
        }

    }
}
