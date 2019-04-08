package com.example.layoutui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.InitAtapter;
import com.example.firstdemo.R;
import com.example.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewUITowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_uitow);

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Item  item = new Item();
            item.setName("张三" + i);
            item.setResource(R.mipmap.ic_launcher);
            list.add(item);
        }
        ListView listView = findViewById(R.id.listView_2);
        InitAtapter atapter = new InitAtapter(this, R.layout.activity_item,list);
        listView.setAdapter(atapter);
    }
}
