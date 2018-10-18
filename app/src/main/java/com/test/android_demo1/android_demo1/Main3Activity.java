package com.test.android_demo1.android_demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends Activity {

    //    定义要显示的数据
    private String[] datas = {"张三","李四","王五","麻子","小强"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main3);
        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );


//        Intent intent = getIntent();
//        String name1 = intent.getStringExtra("name1");
//        String name2 = intent.getStringExtra("name2");
//        String name3 = intent.getStringExtra("name3");

         //取上个页面的传值
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);// int
        String name = intent.getStringExtra("name");// String
        String homeEditTextValue1 = intent.getStringExtra("homeEditTextValue1");
        String homeEditTextValue11 = intent.getStringExtra("homeEditTextValue2");


        //将上页的传值赋给页面textView
        TextView viewById = findViewById(R.id.MainTextView1);
        viewById.setText(id+"\n"+name+"\n"+homeEditTextValue1+"\n"+homeEditTextValue11);
//        Log.d("textsss","---"+id+'\n');
//        Log.d("textsss","---"+id+'\n'+name+'\n'+homeEditTextValue1+'\n');

        //导包 alt+回车
        ListView viewById1 = findViewById(R.id.ListView1);
        //ctrl+p 查看有啥参数
//        初始化适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,datas);
        viewById1.setAdapter(adapter);


    }
}
