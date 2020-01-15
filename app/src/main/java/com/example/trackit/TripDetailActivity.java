package com.example.trackit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TripDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);

        Intent intent = getIntent();

        String trip = intent.getStringExtra(TripsActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.tv_trip);

        textView.setText(trip);
    }
}
