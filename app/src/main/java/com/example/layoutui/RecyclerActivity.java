package com.example.layoutui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.InitAtapter;
import com.example.adapter.RecyclerAdapter;
import com.example.firstdemo.R;
import com.example.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private List<Item> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.setName("张三" + i);
            item.setResource(R.mipmap.ic_launcher);
            list.add(item);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerList);
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

//        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Item item = list.get(position);
//                Toast.makeText(ListViewUITowActivity.this,item.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
