package com.digitalflow.Kwanzaa;

import android.app.IntentService;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class GeocodeService extends IntentService {
    private final static String TAG = "GEOCODER_SERVICE";
    protected ResultReceiver mReceiver;
    protected String resultMsg = "";

    public GeocodeService() {
        super("GeocodeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "Intent received");

        // Get the receiver and the Location data from the incoming Intent
        mReceiver = intent.getParcelableExtra(Constants.RECEIVER_KEY);
        Location location = null;
        final String action = intent.getAction();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        // Address found using the Geocoder.
        List<Address> addresses = null;

        try {
            if (action.equals(Constants.ACTION_ADDRESS_FROM_LOC)) {
                location = intent.getParcelableExtra(Constants.LOCATION_KEY);

                // getFromLocation() returns an array of Addresses for the area near
                // the given latitude and longitude. The results are approximate and
                // not guaranteed to be accurate.
                addresses = geocoder.getFromLocation(
                        location.getLatitude(),
                        location.getLongitude(),
                        1);
            } else if (action.equals(Constants.ACTION_LOC_FROM_ADDR)) {
                String locName = intent.getStringExtra(Constants.PLACE_NAME_KEY);

                // getFromLocationName() returns an array of Addresses that match
                // a described location. This can be a city name, an airport code,
                // an actual address, etc.
                addresses = geocoder.getFromLocationName(locName, 1);
            }
        } catch (IOException e) {
            resultMsg = "IOException occurred";
            Log.d(TAG, "Could not fetch result " + e.getLocalizedMessage());
            deliverResult(Constants.RESULT_ERROR, null);
        } catch (IllegalArgumentException illegalArgumentException) {
            resultMsg = "Illegal arguments passed to Geocoder";
            Log.d(TAG, "Illlegal arguments: " + illegalArgumentException.getLocalizedMessage());
            deliverResult(Constants.RESULT_ERROR, null);
        }

        if (addresses == null || addresses.isEmpty()) {
            resultMsg = "No addresses found for this location";
            deliverResult(Constants.RESULT_ERROR, null);
        } else {
            // put the address into the result
            Address addr = addresses.get(0);
//            String addrString = "";
//
//            // Get the address lines
//            for(int i = 0; i < addr.getMaxAddressLineIndex(); i++) {
//                addrString += addr.getAddressLine(i) + "\n";
//            }
//            // Use other functions to get additional address information
//            if (addr.getCountryName() != null)
//                addrString += addr.getCountryName() + "\n";;
//
//            if (action.equals(Constants.ACTION_ADDRESS_FROM_LOC)) {
//                if (addr.getLocality() != null)
//                    addrString += addr.getLocality() + "\n";;
//                if (addr.getFeatureName() != null) {
//                    addrString += addr.getFeatureName() + "\n";;
//                }
//            }
//            else if (action.equals(Constants.ACTION_LOC_FROM_ADDR)) {
//                if (addr.hasLatitude())
//                    addrString += String.format("Lat: %f", addr.getLatitude()) + "\n";;
//                if (addr.hasLongitude()) {
//                    addrString += String.format("Lat: %f", addr.getLongitude()) + "\n";;
//                }
//            }

            Log.i(TAG, "Address Found");
            deliverResult(Constants.RESULT_SUCCESS, addr);
        }
    }

    /**
     * Sends the given result back to our calling Activity
     */
    protected void deliverResult(int resultCode, Address address) {
        Bundle b = new Bundle();
        double latitude = 0;
        double longitude = 0;
        String theCity = "";
        String theState = "";
        if (address != null) {
            latitude = address.getLatitude();
            longitude = address.getLongitude();
            theCity = address.getLocality();
            theState = address.getAdminArea();
        }
        b.putDouble("latitude", latitude);
        b.putDouble("longitude", longitude);
        b.putString("city", theCity);
        b.putString("state", theState);
//        intent.putExtra("country",country);
//        intent.putExtra("zip",postalCode);
        mReceiver.send(resultCode, b);

    }
}
