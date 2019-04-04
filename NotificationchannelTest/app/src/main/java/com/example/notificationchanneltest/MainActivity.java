package com.example.notificationchanneltest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sendChat;
    Button sendSubscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            String channelId="chat";
            String channelName="聊天";
            int channelImportance=NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId,channelName,channelImportance);
            channelId="subscribe";
            channelName="订阅";
            channelImportance=NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId,channelName,channelImportance);

        }
        sendChat=findViewById(R.id.send_chat);
        sendSubscribe=findViewById(R.id.send_subscribe);
        sendChat.setOnClickListener(this);
        sendSubscribe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_chat:
                NotificationManager manager1= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification1=new NotificationCompat.Builder(this,"chat")
                        .setContentTitle("收到一条聊天消息").setContentText("今天中午吃什么").setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background))
                        .setAutoCancel(true).setWhen(System.currentTimeMillis()).build();
                manager1.notify(1,notification1);
                break;
            case R.id.send_subscribe:
                NotificationManager manager2= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification2=new NotificationCompat.Builder(this,"subscribe")
                        .setContentTitle("你收到一条订阅消息").setContentText("小米9今天抢购")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background))
                        .setAutoCancel(true).build();
                manager2.notify(2,notification2);
                break;
            default:
                break;
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int channelImportance){
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel channel=new NotificationChannel(channelId,channelName,channelImportance);
        manager.createNotificationChannel(channel);

    }
}
