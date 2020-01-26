package com.alimurtaza.android.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;

    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing all the components.
        mWebsiteEditText = findViewById(R.id.website_editText);
        mLocationEditText = findViewById(R.id.location_editText);
        mShareTextEditText = findViewById(R.id.share_editText);
    }

    public void openWebsite(View view) {
        //Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        //Parse the URI and create new Intent.
        Uri webPage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);

        //Find the activity to handle the intent and start that activity.
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        //Get the text from EditText.
        String txt = mShareTextEditText.getText().toString();

        //Set the type for ShareCompat.IntentBuilder Method.
        String mimeType = "text/plain";

        //Default methods for ShareCompat
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }

    public void take_a__picture(View view) {
        //Create a Intent to launch a camera Activity.
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Find the activity to handle the intent, and start the activity.
        if (takePicture.resolveActivity(getPackageManager()) != null) {
            startActivity(takePicture);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
