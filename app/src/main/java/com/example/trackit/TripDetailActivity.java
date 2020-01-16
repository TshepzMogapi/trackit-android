package com.example.trackit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TripDetailActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            TripDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log("onCreate");
        setContentView(R.layout.activity_trip_detail);

        Intent intent = getIntent();

        String trip = intent.getStringExtra(TripsActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.tv_trip);

        textView.setText(trip);
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
}
