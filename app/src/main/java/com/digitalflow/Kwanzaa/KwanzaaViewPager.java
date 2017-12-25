package com.digitalflow.Kwanzaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.digitalflow.Kwanzaa.adapter.CustomPagerAdapter;
import com.digitalflow.Kwanzaa360.R;

import java.util.List;

import static com.digitalflow.Kwanzaa.DataAccess.GetListOfKwanzaaDays;

public class KwanzaaViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwanzaa_view_pager);
        Intent intent = getIntent();
        String theDate = "";
        if (intent.getExtras() != null) {
            theDate = intent.getExtras().getString("thedate");
        }
        List<KwanzaaDay> kwanzaaDayList = GetListOfKwanzaaDays(theDate);
        ViewPager viewPager = findViewById(R.id.ViewPager);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this, kwanzaaDayList);
        viewPager.setAdapter(customPagerAdapter);

    }

}
