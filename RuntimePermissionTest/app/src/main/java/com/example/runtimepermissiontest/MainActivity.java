package com.example.runtimepermissiontest;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button call=findViewById(R.id.call_phone);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //检查用户是否授权
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    //若此程序没有打电话的权限,向用户来请求申请权限
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);

                }else {
                    call();

                }
            }
        });
    }
    private void call(){
        try{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch (Exception e){
        e.printStackTrace();
        }
    }


    //处理权限请求相应，不管用户如何回应权限相应，均会执行此步

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    call();//表示用户为此权限授权
                }else {
                    Toast.makeText(MainActivity.this,"you denied the permission",Toast.LENGTH_SHORT).show();
                }
                break;

            default:
        }
    }
}
