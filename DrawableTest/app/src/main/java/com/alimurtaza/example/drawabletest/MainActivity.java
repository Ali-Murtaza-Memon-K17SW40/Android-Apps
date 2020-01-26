package com.alimurtaza.example.drawabletest;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LevelListDrawable batteryPercentage;
    ImageView imageView;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.battery);
        imageView.setBackgroundResource(R.drawable.level_list);

    }

    public void decreaseBattery(View view) {
        imageView.setImageLevel(count--);
    }

    public void increaseBattery(View view) {
        imageView.setImageLevel(count++);
    }
}
