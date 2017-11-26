package com.digitalflow.Kwanzaa;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BusinessLogic {
    private static BusinessLogic logic = new BusinessLogic();

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
        List<String> KwanzaaDates = Arrays.asList("12/16", "12/27", "12/28", "12/29", "12/30", "12/31", "1/1");
        return KwanzaaDates.contains(sDateEntered);
    }

    protected int daysUntilKwanzaa(String sDateEntered) {
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
            //    if(workingDate.before(today))
            //    {
            //    workingDate.add(Calendar.YEAR,1);
            //    }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate Date1 = new LocalDate(workingDate);
        LocalDate Date2 = new LocalDate(FirstDayOfKwanzaa);
        int days = Days.daysBetween(Date1, Date2).getDays();
        if (days < 0) {
            days = 365 + days;
        }
        return days;
    }
}
