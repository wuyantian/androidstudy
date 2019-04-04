package com.example.notificicationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sendNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotify=findViewById(R.id.send_notify);
        sendNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.send_notify){

            //创建通知管理器
            NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            Intent intent=new Intent(this,Main2Activity.class);
            PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);

            //创建通知对象

            Notification notification=new NotificationCompat.Builder(this,"default").setAutoCancel(true).
                    setContentText("This is content text").setContentTitle("This is content title").setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.drawable.ic_launcher_background).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background)).setContentIntent(pi).build();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                String channelId = "default";
                String channelName = "默认通知";
                notificationManager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH));
            }

            notificationManager.notify(1,notification);

        }

    }
}
