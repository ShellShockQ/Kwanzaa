package com.digitalflow.Kwanzaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.digitalflow.Kwanzaa360.R;

import org.joda.time.LocalDate;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final public BusinessLogic mBusinessLogic = new BusinessLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_top);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        String sTodaysDate = getDateAsAString();
        DisplayAppropriateImageBasedOnDate(sTodaysDate);
        SetupLearnMoreButton();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void SetupLearnMoreButton() {
        ImageButton LearnMoreButton = findViewById(R.id.LearnMoreButton);
        LearnMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPagerIntent = new Intent(MainActivity.this, KwanzaaViewPager.class);
                startActivity(viewPagerIntent);
            }
        });
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ICelebrate) {
            Intent iCelebrateIntent = new Intent(MainActivity.this, ICelebrateKwanzaa.class);
            startActivity(iCelebrateIntent);

        } else if (id == R.id.nav_suppliers) {

        } else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_trivia) {

        } else if (id == R.id.nav_ecard) {

        } else if (id == R.id.nav_cashmob) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
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
}
