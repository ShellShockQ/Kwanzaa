package com.digitalflow.Kwanzaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalflow.Kwanzaa360.R;

import org.joda.time.LocalDate;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    final public BusinessLogic mBusinessLogic = new BusinessLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sTodaysDate = getDateAsAString();
        DisplayAppropriateImageBasedOnDate(sTodaysDate);
        ImageButton LearnMoreButton = findViewById(R.id.LearnMoreButton);
        LearnMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPagerIntent = new Intent(MainActivity.this, KwanzaaViewPager.class);
                startActivity(viewPagerIntent);
            }
        });
    }

    @NonNull
    private String getDateAsAString() {
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

    public void DisplayAppropriateImageBasedOnDate(String sDateEntered) {
        ImageView img = findViewById(R.id.imgCandles);
        int dImage = R.drawable.dayuntil;
        if (mBusinessLogic.isAKWANZAAday(sDateEntered)) {
            if (sDateEntered.equals("12/26")) {
                dImage = R.drawable.kwanzaa_day_01;
            }
        } else {
            TextView tvDaysUntil = findViewById(R.id.daysUntilText);
            int daysToGo = mBusinessLogic.daysUntilKwanzaa(sDateEntered);
            tvDaysUntil.setText(Integer.toString(daysToGo));
        }
        img.setImageResource(dImage);

    }


}
