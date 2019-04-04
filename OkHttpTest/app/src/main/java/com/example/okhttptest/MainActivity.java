package com.example.okhttptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest=findViewById(R.id.send_request);
        responseText=findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.send_request){
            //点击按钮，向服务器请求数据
            sendRequestWithOkHttp();

        }

    }
    private void  sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("https://www.baidu.com").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }
    private  void showResponse(final String response){
        runOnUiThread(new Runnable() {//向请求到的数据展示给页面
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }
}
