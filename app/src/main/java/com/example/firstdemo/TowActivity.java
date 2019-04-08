package com.example.firstdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TowActivity extends AppCompatActivity {

    private static final String TAG = "TowActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");//获取参数
        Log.d(TAG, "onCreate: 接受参数：" + data);

        /**
         * 返回按钮
         */
        Button button = findViewById(R.id.button_return_towActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("resultData", "我已经关闭了");
                setResult(RESULT_OK,intent);//设置返回结果
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("resultData", "我已经关闭了");
        setResult(RESULT_OK, intent);
        finish();
    }
}
