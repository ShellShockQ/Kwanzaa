package com.digitalflow.Kwanzaa;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.digitalflow.Kwanzaa360.R;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Context.NOTIFICATION_SERVICE;

public class BusinessLogic {
    private static BusinessLogic logic = new BusinessLogic();

    public static int daysUntilKwanzaa(String sDateEntered) {
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
        Calendar today = Calendar.getInstance();
        Calendar workingDate = Calendar.getInstance();
        int currYear = today.get(Calendar.YEAR);
        String dateInString = "12/26/" + Integer.toString(currYear);
        Date FirstDayOfKwanzaa = null;
        Date enteredDate = null;
        try {
            FirstDayOfKwanzaa = formatter.parse(dateInString);
            workingDate.setTime(formatter.parse(sDateEntered + "/" + Integer.toString(currYear)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate Date1 = new LocalDate(workingDate);
        LocalDate Date2 = new LocalDate(FirstDayOfKwanzaa);
        int days = Days.daysBetween(Date1, Date2).getDays();
        if (days > 358) {
            days = 0;
        }
        if (days < 0) {
            days = 365 + days;
        }

        return days;
    }

    public static String getDateAsAString() {
        String sTodaysDate;
        LocalDate today = LocalDate.now();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today.toDate());
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String sMonth = Integer.toString(month + 1);
        String sDay = Integer.toString(day);
        sTodaysDate = sMonth + "/" + sDay;
        return sTodaysDate;
    }

    public static void setupAlarmManager() {
        Calendar alarmTime = Calendar.getInstance();
        alarmTime.set(Calendar.HOUR_OF_DAY, 7);
        // alarmTime.set(Calendar.HOUR_OF_DAY,19);
        //  alarmTime.set(Calendar.MINUTE,25);
        AlarmManager alarmManager = (AlarmManager) Kwanzaa360.getAppContext().getSystemService(ALARM_SERVICE);
        Intent intentAlarm = new Intent(Kwanzaa360.getAppContext(), NotificationReciever.class);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime.getTimeInMillis(), PendingIntent.getBroadcast(Kwanzaa360.getAppContext(), 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));
    }

    protected String WhichDayOfKwanzaaIsItInSwahili(String sDateEntered) {
        String sKwanzaaDay = "";
        if (sDateEntered.equals("12/26")) {
            sKwanzaaDay = "Umoja";
        }
        if (sDateEntered.equals("12/27")) {
            sKwanzaaDay = "Kujichagulia";
        }
        if (sDateEntered.equals("12/28")) {
            sKwanzaaDay = "Ujima";
        }
        if (sDateEntered.equals("12/29")) {
            sKwanzaaDay = "Ujamaa";
        }
        if (sDateEntered.equals("12/30")) {
            sKwanzaaDay = "Nia";
        }
        if (sDateEntered.equals("12/31")) {
            sKwanzaaDay = "Kuumba";
        }
        if (sDateEntered.equals("1/1")) {
            sKwanzaaDay = "Nia";
        }
        return sKwanzaaDay;
    }

    protected String WhichDayOfKwanzaaIsItInEnglish(String sDateEntered) {
        String sEnglishKwanzaaDay = "";
        String sSwahiliKwanzaaDay = logic.WhichDayOfKwanzaaIsItInSwahili(sDateEntered);
        if (sSwahiliKwanzaaDay.equals("Umoja")) {
            sEnglishKwanzaaDay = "Unity";
        }
        if (sSwahiliKwanzaaDay.equals("Kujichagulia")) {
            sEnglishKwanzaaDay = "Self Determination";
        }
        if (sSwahiliKwanzaaDay.equals("Ujima")) {
            sEnglishKwanzaaDay = "Collective Work and Responsibility";
        }
        if (sSwahiliKwanzaaDay.equals("Ujamaa")) {
            sEnglishKwanzaaDay = "Collective Economics";
        }
        if (sSwahiliKwanzaaDay.equals("Kuumba")) {
            sEnglishKwanzaaDay = "Creativity";
        }
        if (sSwahiliKwanzaaDay.equals("Nia")) {
            sEnglishKwanzaaDay = "Purpose";
        }

        return sEnglishKwanzaaDay;
    }

    public Boolean isAKWANZAAday(String sDateEntered) {
        List<String> KwanzaaDates = Arrays.asList("12/26", "12/27", "12/28", "12/29", "12/30", "12/31", "1/1");
        return KwanzaaDates.contains(sDateEntered);
    }

    public void KwanzaaNotify(String theDate) {
        if (theDate == "" || theDate == null) {
            theDate = BusinessLogic.getDateAsAString();
        }
        Intent workingIntent = null;
        int daysToGo = BusinessLogic.daysUntilKwanzaa(theDate);
        String title = "";
        String text = "";
        if (isAKWANZAAday(theDate)) {
            List<KwanzaaDay> kwanzaaDay = DataAccess.GetListOfKwanzaaDays(theDate);
            title = "Happy Kwanzaa";
            text = String.format("%s(%s) - %s", kwanzaaDay.get(0).EnglishName, kwanzaaDay.get(0).SwahiliName, kwanzaaDay.get(0).ShortExplanation);
            try {
                workingIntent = new Intent(Kwanzaa360.getAppContext(), KwanzaaViewPager.class);
                workingIntent.setAction("KwanzaaNotifier");
                workingIntent.putExtra("thedate", theDate);
                Kwanzaa360.getAppContext().startActivity(workingIntent);
            } catch (Exception ex) {

                Toast.makeText(Kwanzaa360.getAppContext(), "We are experiencing an issue. We have been notified and we're correcting it. Thank you for your patience", Toast.LENGTH_LONG).show();
            }

        } else {
            title = "Kwanzaa 360";
            text = String.format("%01d days until Kwanzaa", daysToGo);
        }
        NotificationCompat.Builder builder = initBasicBuilder(title, text, workingIntent);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) Kwanzaa360.getAppContext().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(360, notification);
    }

    public NotificationCompat.Builder initBasicBuilder(String title, String text, Intent intent) {
        String channelId = "Kwanzaa360";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Kwanzaa360.getAppContext(), channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(Kwanzaa360.getAppContext().getResources(), R.drawable.kwanzaamenuheader))
                .setContentTitle(title)
                .setTicker("KWANZAA 360")
                .setAutoCancel(true)
                .setContentText(text);
        if (intent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(Kwanzaa360.getAppContext(), 0, intent, 0);
            builder.setContentIntent(pendingIntent);
        }
        return builder;

    }
}
