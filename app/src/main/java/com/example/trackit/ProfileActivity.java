package com.example.trackit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private EditText mWebsiteText;
    private EditText mLocationText;
    private EditText mTextMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mWebsiteText = findViewById(R.id.et_website);

        mLocationText = findViewById(R.id.et_location);

        mTextMessageText = findViewById(R.id.et_text_sms);

    }

    public void openWebsite(View view) {

        String url = mWebsiteText.getText().toString();

        Uri webPage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);

        } else {
            Toast.makeText(this, "Can't handle this.", Toast.LENGTH_SHORT);
        }
    }

    public void openLocation(View view) {

        String location = mLocationText.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + location);

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);

        } else {
            Toast.makeText(this, "Can't handle this.", Toast.LENGTH_SHORT);
        }



    }

    public void sendText(View view) {

        String text = mTextMessageText.getText().toString();

        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share text with")
                .setText(text)
                .startChooser();
    }
}
