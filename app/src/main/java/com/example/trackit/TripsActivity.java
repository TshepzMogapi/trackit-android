package com.example.trackit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TripsActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            TripsActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.example.trackit.extra.MESSAGE";

    private EditText mTripEditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        log("onCreate");

        setContentView(R.layout.activity_trips);

        mTripEditText = findViewById(R.id.et_trip_name);


    }

    @Override
    protected void onStart() {
        super.onStart();

        log("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("onPause");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        log("onRestart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onStop() {

        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("onDestroy");
    }

    private void log(String logMessage) {
        Log.d(LOG_TAG, "-----------");
        Log.d(LOG_TAG, logMessage);
        Log.d(LOG_TAG, "-----------");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void launchTripDetail(View view) {
        Log.d(LOG_TAG, "Starting Trip Detail");

        Intent intent = new Intent(this, TripDetailActivity.class);

        String trip = mTripEditText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, trip);

        startActivity(intent);
    }
}
