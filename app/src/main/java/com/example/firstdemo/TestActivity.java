package com.example.firstdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.layoutui.FrameUIActivity;
import com.example.layoutui.LinearLayoutUIActivity;
import com.example.layoutui.ListViewUIActivity;
import com.example.layoutui.ListViewUITowActivity;
import com.example.layoutui.RecyclerActivity;
import com.example.layoutui.RelativeLayoutUiActivity;
import com.example.layoutui.RelativeLayoutUiTowActivity;


public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            String data = savedInstanceState.getString("data");
        }
        Log.d(TAG, TestActivity.class.getSimpleName());
        /**
         * 在活动中加载布局,传入布局文件的ID，项目中添加的任何资源都会在R文件中生成资源ID
         */
        setContentView(R.layout.activity_test);
        /**
         * 隐藏系统自带的标题栏
         */
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null){
            supportActionBar.hide();
        }
        /**
         * 通过ID查找按钮
         */
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(this);

        Button LinearLayoutBtn = findViewById(R.id.linearLayout);
        LinearLayoutBtn.setOnClickListener(this);

        Button relative_1 = findViewById(R.id.relativeLayoutBtn_1);
        relative_1.setOnClickListener(this);

        Button relative_2 = findViewById(R.id.relativeLayoutBtn_2);
        relative_2.setOnClickListener(this);

        Button frameBtn = findViewById(R.id.frameLayoutBtn);
        frameBtn.setOnClickListener(this);

        Button listViewUI = findViewById(R.id.listViewUI_1);
        listViewUI.setOnClickListener(this);

        Button listViewUI_2 = findViewById(R.id.listViewUI_2);
        listViewUI_2.setOnClickListener(this);

        Button recycler = findViewById(R.id.recyclerViewUI_1);
        recycler.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * 选中菜单的时候
         */
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"add", Toast.LENGTH_SHORT).show();
            case R.id.del_item:
                Toast.makeText(this,"del", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        /**
         * 接受活动结束后的返回参数
         */
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String resultData = data.getStringExtra("resultData");
                    Log.d(TAG, "onActivityResult: 接受到返回参数" + resultData);
                }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /**
         * 活动被回收前一定会被调用
         */
        super.onSaveInstanceState(outState);
        outState.putString("data", "a");
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.button_1:
                intent = new Intent("startTowActivity");
                intent.addCategory("myCategory");
                //设置需要传递的参数
                intent.putExtra("data","helloWord");
                /**
                 * 调用的活动结束后需要一个返回结果
                 */
                startActivityForResult(intent, 1);
                break;
            case R.id.button_2:
                /**
                 * 调用浏览器，intent内置的类型
                 */
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.button_3:
                /**
                 * 调用电话，intent内置的类型
                 */
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.button_4:
                intent = new Intent("dialogActivity");
                startActivity(intent);
                break;
            case R.id.linearLayout:
                /**
                 * 调用线性布局UI
                 */
                intent = new Intent(this, LinearLayoutUIActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeLayoutBtn_1:
                /**
                 * 调用相对布局UI1
                 */
                intent = new Intent(this, RelativeLayoutUiActivity.class);
                startActivity(intent);
                break;
            case R.id.relativeLayoutBtn_2:
                /**
                 * 调用相对布局UI2
                 */
                intent = new Intent(this, RelativeLayoutUiTowActivity.class);
                startActivity(intent);
                break;
            case R.id.frameLayoutBtn:
                /**
                 * 调用帧布局UI1
                 */
                intent = new Intent(this, FrameUIActivity.class);
                startActivity(intent);
                break;
            case R.id.listViewUI_1:
                /**
                 * 调用ListView控件
                 */
                intent = new Intent(this, ListViewUIActivity.class);
                startActivity(intent);
                break;
            case R.id.listViewUI_2:
                /**
                 * 调用自定义ListView控件
                 */
                intent = new Intent(this, ListViewUITowActivity.class);
                startActivity(intent);
                break;
            case R.id.recyclerViewUI_1:
                /**
                 * 调用自定义RecyclerView控件
                 */
                intent = new Intent(this, RecyclerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
