package com.example.trackit;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity
    implements FetchAddressTask.OnTaskCompleted {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final String TRACKING_LOCATION_KEY = "tracking_location";

    private Location mLastLocation;

    private TextView mLocationTextView;

    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLocationTextView =  findViewById(R.id.tv_location);


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(
                this);

    }

    public void startTrip(View view) {

        getLocation();

        Toast toast = Toast.makeText(this, R.string.toast_start_trip,
                Toast.LENGTH_SHORT);

        toast.show();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            Log.d(LOG_TAG, "getLocation: permissions granted");

            mFusedLocationClient.getLastLocation().addOnSuccessListener(
                    new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {
                                new FetchAddressTask(MainActivity.this,
                                        MainActivity.this).execute(location);

                            } else {
                                mLocationTextView.setText("No location found.");
                            }

                        }
                    }
            );

        }
        mLocationTextView.setText(getString(R.string.address_text,
                getString(R.string.loading),
                System.currentTimeMillis()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // If the permission is granted, get the location,
                // otherwise, show a Toast
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    Toast.makeText(this,
                            "Permission Denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onTaskCompleted(String result) {
        mLocationTextView.setText(getString(R.string.address_text,
                result, System.currentTimeMillis()));
    }
}
