package com.digitalflow.Kwanzaa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Detrick on 12/24/2017.
 */

public class NotificationReciever extends BroadcastReceiver {
    final String theDate = BusinessLogic.getDateAsAString();

    @Override
    public void onReceive(Context context, Intent intent) {
        BusinessLogic businessLogic = new BusinessLogic();
        businessLogic.KwanzaaNotify(theDate);
    }
}
