package com.example.wuyantian.cloudmusic;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button login ,register;
    ImageView qq,wechat,wb,wy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        login=findViewById(R.id.log_in);
        register=findViewById(R.id.register);
        qq=findViewById(R.id.qq);
        wechat=findViewById(R.id.wechat);
        wb=findViewById(R.id.wb);
        wy=findViewById(R.id.wy);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent2);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在拉起手机QQ",Toast.LENGTH_SHORT).show();

            }
        });
        wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在拉起手机微信",Toast.LENGTH_SHORT).show();

            }
        });
        wb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在拉起手机微博",Toast.LENGTH_SHORT).show();

            }
        });
        wy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在拉起手机网易邮箱",Toast.LENGTH_SHORT).show();

            }
        });





    }




}

