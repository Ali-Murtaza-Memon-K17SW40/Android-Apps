package com.alimurtaza.android.inputcontrolshomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the views
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
    }

    public void onSubmit(View view) {
        String display_message = null;
        /*
        Checking which checkBoxes are selected and toast the message on screen.
        */
        if (checkBox1.isChecked()) {
            display_message = ((CheckBox) findViewById(R.id.checkBox1)).getText().toString() + " ";
        }

        if (checkBox2.isChecked()) {
            display_message += ((CheckBox) findViewById(R.id.checkBox2)).getText().toString() + " ";
        }

        if (checkBox3.isChecked()) {
            display_message += ((CheckBox) findViewById(R.id.checkBox3)).getText().toString() + " ";
        }

        if (checkBox4.isChecked()) {
            display_message += ((CheckBox) findViewById(R.id.checkBox4)).getText().toString() + " ";
        }

        if (checkBox5.isChecked()) {
            display_message += ((CheckBox) findViewById(R.id.checkBox5)).getText().toString();
        }

        displayToast(display_message);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), "Toppings: " + message, Toast.LENGTH_SHORT).show();
    }

    public void onCheckBoxClicked(View view) {
    }
}
