package com.example.logintest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefer;
    SharedPreferences.Editor editor;
    EditText account;
    EditText password;
    CheckBox rememberPass;
    Button logIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        prefer= PreferenceManager.getDefaultSharedPreferences(this);
        account=findViewById(R.id.content_account);
        password=findViewById(R.id.content_password);
        rememberPass=findViewById(R.id.is_remember);
        logIn=findViewById(R.id.log_in);
        //读取数据
        Boolean isRemember=prefer.getBoolean("isremember",false);
        if (isRemember){
            String accountContent=prefer.getString("account","");
            String passwordContent= prefer.getString("password","");
            account.setText(accountContent);
            password.setText(passwordContent);
            rememberPass.setChecked(true);
        }

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountContent=account.getText().toString();
                String passwordContent=password.getText().toString();
                if (accountContent.equals("wuyantian")&&passwordContent.equals("123456")){
                    editor=prefer.edit();
                    //存入数据
                    if (rememberPass.isChecked()){
                        editor.putString("account",accountContent);
                        editor.putString("password",passwordContent);
                        editor.putBoolean("isremember",true);
                    }else {
                        editor.clear();

                    }
                    editor.apply();
                    Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"your account or password is not true ",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
