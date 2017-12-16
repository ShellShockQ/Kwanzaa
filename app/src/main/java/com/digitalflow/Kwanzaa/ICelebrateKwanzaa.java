package com.digitalflow.Kwanzaa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.digitalflow.Kwanzaa360.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

public class ICelebrateKwanzaa extends AppCompatActivity
        implements OnConnectionFailedListener, ConnectionCallbacks {
    final String TAG = "ICelebrateKwanzaa";
    public Bundle mAddress;
    protected GoogleApiClient mGoogleApiClient;
    protected AddressReceiver mAddressReceiver;
    protected boolean mHaveLocPerm;
    protected Location mLastLocation;

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
        getAddressFromLoc();
        updateUI();
    }


    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }


    @Override
    protected void onResume() {
        super.onResume();
        getAddressFromLoc();
        updateUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        setContentView(R.layout.activity_icelebrate_kwanzaa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAddressReceiver = new AddressReceiver(new Handler());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    protected void getAddressFromLoc() {
        Log.i(TAG, "getAddressFromLoc");
        if (mGoogleApiClient.isConnected() && mHaveLocPerm) {
            try {
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            } catch (SecurityException e) {
                Log.d(TAG, "Could not access LocationServices");
            }

            if (mLastLocation != null) {
                // Create the intent service responsible for getting the address.
                Intent intent = new Intent(this, GeocodeService.class);

                intent.setAction(Constants.ACTION_ADDRESS_FROM_LOC);
                intent.putExtra(Constants.RECEIVER_KEY, mAddressReceiver);
                intent.putExtra(Constants.LOCATION_KEY, mLastLocation);

                // Start the service. If the service isn't already running, it is instantiated and started
                // (creating a process for it if needed); if it is running then it remains running. The
                // service kills itself automatically once all intents are processed.
                startService(intent);
            }
        }
    }

    protected void updateUI() {
        Log.i(TAG, "updateUI");
        if (mAddress != null) {
            String city = mAddress.getString("city") + "," + mAddress.getString("state");
            int count = 0;
            getAddressFromLoc();
            TextView textView = findViewById(R.id.tvIcelebrate);
            textView.setText(String.format("There are %01d people in %s that have said Yes, I'm celebrate Kwanzaa this year. Click the Add button below to be counted.", count, city));
        }
    }
    @Override
    public void onConnected(Bundle connectionHint) {
        Log.i(TAG, "onConnected");
        int permCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (permCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            mHaveLocPerm = true;
        }
        getAddressFromLoc();
        updateUI();
    }




    @Override
    public void onConnectionSuspended(int cause) {
        Log.i(TAG, "onConnectionSuspended: Connection was suspended, cause code is " + cause);
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.i(TAG, "onConnectionFailed: Connection failed: Error Code of =" + connectionResult.getErrorCode());

    }

    @Override
    public void onRequestPermissionsResult(int reqCode, String[] perms, int[] results) {
        if (reqCode == 1) {
            if (results.length > 0 && results[0] == PackageManager.PERMISSION_GRANTED) {
                mHaveLocPerm = true;
            }
        }
    }

    class AddressReceiver extends ResultReceiver {
        public AddressReceiver(Handler handler) {
            super(handler);
        }

        /**
         * Receives data sent from GeocoderService and updates the UI in MainActivity.
         */
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            // Display the address string or an error message sent from the intent service.
            //.getString(Constants.ADDRESS_RESULT_KEY);
            //   Address current_location = getIntent().getExtras().getParcelable(Constants.ADDRESS_RESULT_KEY);
            mAddress = resultData;
            updateUI();
        }
    }
}

