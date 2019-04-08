package com.example.layoutui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.InitAtapter;
import com.example.firstdemo.R;
import com.example.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ListViewUITowActivity extends AppCompatActivity {

    private List<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_uitow);


        for (int i = 0; i < 10; i++) {
            Item  item = new Item();
            item.setName("张三" + i);
            item.setResource(R.mipmap.ic_launcher);
            list.add(item);
        }
        ListView listView = findViewById(R.id.listView_2);
        InitAtapter atapter = new InitAtapter(this, R.layout.activity_item,list);
        listView.setAdapter(atapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = list.get(position);
                Toast.makeText(ListViewUITowActivity.this,item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
