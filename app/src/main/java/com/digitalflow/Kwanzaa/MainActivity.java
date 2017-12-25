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

import static com.digitalflow.Kwanzaa.BusinessLogic.getDateAsAString;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
    final public BusinessLogic mBusinessLogic = new BusinessLogic();
    final String sTodaysDate = getDateAsAString();
    final BusinessLogic businessLogic = new BusinessLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_top);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        DisplayAppropriateImageBasedOnDate(sTodaysDate);
        SetupLearnMoreButton();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        BusinessLogic.setupAlarmManager();
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
        ImageButton LearnMoreButton = findViewById(R.id.LearnMoreButton);
        TextView tvDaysUntil = findViewById(R.id.daysUntilText);

        int dImage = R.drawable.dayuntil;
        if (mBusinessLogic.isAKWANZAAday(sDateEntered)) {
            Intent viewPagerIntent = new Intent(MainActivity.this, KwanzaaViewPager.class);
            viewPagerIntent.putExtra("thedate", sDateEntered);
            startActivity(viewPagerIntent);
        } else {
            int daysToGo = BusinessLogic.daysUntilKwanzaa(sDateEntered);
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
        } else if (id == R.id.nav_activities) {
            Intent KwanzaaActivities = new Intent(MainActivity.this, KwanzaaActivities.class);
            startActivity(KwanzaaActivities);

        } else if (id == R.id.nav_events) {

        } else if (id == R.id.nav_trivia) {

        } else if (id == R.id.nav_ecard) {

        } else if (id == R.id.nav_cashmob) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
