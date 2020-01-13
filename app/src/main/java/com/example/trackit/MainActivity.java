package com.example.trackit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startTrip(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_start_trip,
                Toast.LENGTH_SHORT);

        toast.show();
    }
}
