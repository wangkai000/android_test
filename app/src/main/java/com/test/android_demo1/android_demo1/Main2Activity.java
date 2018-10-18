package com.test.android_demo1.android_demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Main2Activity extends Activity {

    private String name1;//ctrl+alt+v 定义成全局
    private String name2;
    private String name3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        //页面传值显示的方法
        Intent intent = getIntent();
        name1 = intent.getStringExtra("name1");
        name2 = intent.getStringExtra("name2");
        name3 = intent.getStringExtra("name3");

        //TextView  textView=findViewById(R.id.TextView2);
        //textView.setText(name1+'\n'+name2+'\n'+name3);


        //点击护理跳转下一个页面
        View viewById = findViewById(R.id.huli);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //声明意图
                Intent intent = new Intent();

                intent.putExtra("id", 66666); // int
                intent.putExtra("name", "测试数据"); // String
                intent.putExtra("homeEditTextValue1",name1);//上一页的变量
                intent.putExtra("homeEditTextValue2",name2);
                intent.setClass(Main2Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });



    }


}
