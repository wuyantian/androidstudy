package com.example.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create=findViewById(R.id.create_database);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        Button save=findViewById(R.id.save_data);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Book book=new Book();
               book.setAuthor("ddwddd");
               book.setId(1);
               book.setName("wfifif");
               book.setPages(12);
               book.setPrice(24.8);
               book.save();
            }
        });
    }
}
