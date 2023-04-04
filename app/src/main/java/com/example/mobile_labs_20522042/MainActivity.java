package com.example.mobile_labs_20522042;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.customListView);
        listView.setNestedScrollingEnabled(false);
        CustomListAdapter customAdapter = new CustomListAdapter(getApplicationContext());
        listView.setAdapter(customAdapter);

        gridView = findViewById(R.id.gridView);
        gridView.setNestedScrollingEnabled(false);
        CustomGridAdapter customGridAdapter = new CustomGridAdapter(getApplicationContext());
        gridView.setAdapter(customGridAdapter);
    }
}