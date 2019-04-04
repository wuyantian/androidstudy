package com.example.wuyantian.cloudmusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register;
    private EditText accountId;
    private EditText passwordId;
    GlobalData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data=(GlobalData)this.getApplication();
        setContentView(R.layout.activity_register);
        Toolbar toolbar=findViewById(R.id.tool_bar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个返回图标
        getSupportActionBar().setHomeButtonEnabled(true);//返回键可用
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//设置返回点击事件
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        register=findViewById(R.id.register);
        accountId=findViewById(R.id.account_id);
        passwordId=findViewById(R.id.password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountId.getText().toString();
                String password = passwordId.getText().toString();
                if (account.length() != 11) {
                    Toast.makeText(RegisterActivity.this, "号码长度错误", Toast.LENGTH_SHORT).show();
                } else if (password.length() != 6) {
                    Toast.makeText(RegisterActivity.this, "密码长度错误", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(RegisterActivity.this, "注册成功",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    data.setGlobalAccount(account);
                    data.setGlobalPassword(password);
                }
            }
        });



    }
}
