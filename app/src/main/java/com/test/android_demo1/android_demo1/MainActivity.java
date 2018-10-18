package com.test.android_demo1.android_demo1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.android_demo1.android_demo1.api.NetWorks;
import com.test.android_demo1.android_demo1.bean.LogInfo;
import com.test.android_demo1.android_demo1.utils.Http;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends  Activity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        //隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                );

        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.homeButton);
        Button stateButton=findViewById(R.id.stateButton);

        editText1 = findViewById(R.id.EditText1);
        editText2 = findViewById(R.id.EditText2);
        editText3 = findViewById(R.id.EditText3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.putExtra("name1",editText1.getText().toString());
//                intent.putExtra("name2",editText2.getText().toString());
//                intent.putExtra("name3",editText3.getText().toString());
//                intent.setClass(MainActivity.this,Main2Activity.class);
//                startActivity(intent);

                String name = editText1.getText().toString();
                String pwd = editText2.getText().toString();
                Log.d("llll","name="+name);
                Log.d("llll","pwd="+pwd);
                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)){
                    NetWorks retrofit = Http.createRetrofit(MainActivity.this, NetWorks.class);
                    Call<LogInfo> logInfoCall = retrofit.startLogin(name, pwd);
                    logInfoCall.enqueue(new Callback<LogInfo>() {
                        @Override
                        public void onResponse(Call<LogInfo> call, Response<LogInfo> response) {
                            boolean success = response.body().isSuccess();
                            if(success){
                                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.putExtra("name1",editText1.getText().toString());
                                intent.putExtra("name2",editText2.getText().toString());
                                intent.putExtra("name3",editText3.getText().toString());
                                intent.setClass(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<LogInfo> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "name,pwd为空", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(MainActivity.this, editText1.getText(), Toast.LENGTH_LONG).show();
//               1. new Intent(意图)
//                2. intent.setClass(context,Activity.class)
//                (传值)intent.put
//                3. startActicity(intent);
//
            }
        });



        //点击跳转button
        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name1",editText1.getText().toString());
                intent.putExtra("name2",editText2.getText().toString());
                intent.putExtra("name3",editText3.getText().toString());
                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }
}
