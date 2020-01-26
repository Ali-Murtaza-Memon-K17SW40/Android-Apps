package com.alimurtaza.android.shoppingapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private ListView main_list;
    private ArrayList<String> main_shopping_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_list = findViewById(R.id.main_list);

        //Restore the state.
        if (savedInstanceState != null) {

            main_shopping_list = savedInstanceState.getStringArrayList("Key");

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, main_shopping_list);
            main_list.setAdapter(arrayAdapter);
        }
    }

    public void add_item(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (main_shopping_list.size() != 0) {
            outState.putStringArrayList("Key", main_shopping_list);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = null;
                if (data != null) {
                    reply = data.getStringExtra(SecondActivity.EXTRA_ITEM);
                }
                main_shopping_list.add(reply);

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, main_shopping_list);
                main_list.setAdapter(arrayAdapter);
            }
        }
    }
}
