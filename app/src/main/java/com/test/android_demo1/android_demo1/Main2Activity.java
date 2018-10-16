package com.test.android_demo1.android_demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name1");
        String name2 = intent.getStringExtra("name2");
        String name3 = intent.getStringExtra("name3");

        TextView  textView=findViewById(R.id.TextView2);
        textView.setText(name1+'\n'+name2+'\n'+name3);
    }
}
