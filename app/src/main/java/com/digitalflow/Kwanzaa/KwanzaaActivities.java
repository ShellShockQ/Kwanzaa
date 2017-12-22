package com.digitalflow.Kwanzaa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.digitalflow.Kwanzaa360.R;

public class KwanzaaActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwanzaa_activities);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String htmlAsString = getString(R.string.kwanzaaActivitiesText);
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

// set the html content on the TextView
        TextView textView = findViewById(R.id.KwanzaaActivitiesText);
        textView.setText(htmlAsSpanned);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        //TODO: Turn on fab button and change it to a add icon

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
