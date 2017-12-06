package com.digitalflow.Kwanzaa;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.digitalflow.Kwanzaa360.R;

import java.util.List;

import static com.digitalflow.Kwanzaa.DataAccess.GetListOfKwanzaaDays;

public class KwanzaaViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwanzaa_view_pager);
        List<KwanzaaDay> kwanzaaDayList = GetListOfKwanzaaDays();
        ViewPager viewPager = (ViewPager) findViewById(R.id.ViewPager);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(this, kwanzaaDayList);
        viewPager.setAdapter(customPagerAdapter);

    }

}
