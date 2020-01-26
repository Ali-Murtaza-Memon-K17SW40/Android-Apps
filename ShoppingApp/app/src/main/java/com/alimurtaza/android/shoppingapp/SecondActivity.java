package com.alimurtaza.android.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "com.alimurtaza.android.shoppingapp.extra.ITEM";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final ListView listView = findViewById(R.id.listView);

        final ArrayList<String> shopping_list = new ArrayList<>();

        shopping_list.add("Coat");
        shopping_list.add("Shirt");
        shopping_list.add("Pant");
        shopping_list.add("Tie");
        shopping_list.add("Shoes");
        shopping_list.add("Belt");
        shopping_list.add("Watch");
        shopping_list.add("Bracelet");
        shopping_list.add("Underwear");
        shopping_list.add("Glasses");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shopping_list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent replyIntent = new Intent();
                replyIntent.putExtra(EXTRA_ITEM, shopping_list.get(position));
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}
