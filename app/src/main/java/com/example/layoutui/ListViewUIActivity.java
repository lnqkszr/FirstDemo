package com.example.layoutui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.firstdemo.R;

public class ListViewUIActivity extends AppCompatActivity {

    private String[] data = {"1","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ui);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ListView listView = findViewById(R.id.listView_1);
        listView.setAdapter(adapter);
    }
}
