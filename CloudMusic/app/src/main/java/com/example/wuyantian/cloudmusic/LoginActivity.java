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

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText accountId;
    private EditText passwordId;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox checkBox;
    GlobalData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        data=(GlobalData)this.getApplication();
        pref=PreferenceManager.getDefaultSharedPreferences(this);
        Toolbar toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个返回图标
        getSupportActionBar().setHomeButtonEnabled(true);//返回键可用
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//设置返回点击事件
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        login=findViewById(R.id.log_in);
        accountId=findViewById(R.id.account_id);
        passwordId=findViewById(R.id.password);
        checkBox=findViewById(R.id.remember_pass);
        boolean isRemember=pref.getBoolean("remember_password",false);
        if (isRemember){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            accountId.setText(account);
            passwordId.setText(password);
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountId.getText().toString();
                String password=passwordId.getText().toString();
                if (account.equals(data.getGlobalAccount())&&password.equals(data.getGlobalPassword())){
                    editor=pref.edit();
                    if (checkBox.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(LoginActivity.this,SongListActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
