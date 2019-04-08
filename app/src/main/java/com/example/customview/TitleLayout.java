package com.example.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.firstdemo.R;

public class TitleLayout extends LinearLayout  implements View.OnClickListener{

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        /**
         * 获取layoutInflater 方式1
         */
        //LayoutInflater.from(context).inflate(R.layout.title,this);
        /**
         * 获取layoutInflater 方式2
         */
        LayoutInflater localinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        localinflater.inflate(R.layout.title,this);

        Button down = findViewById(R.id.down);
        Button up = findViewById(R.id.up);
        down.setOnClickListener(this);
        up.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.up:
                Toast.makeText(view.getContext(),"上一步", Toast.LENGTH_SHORT).show();
                break;
            case R.id.down:
                Toast.makeText(view.getContext(),"下一步", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
