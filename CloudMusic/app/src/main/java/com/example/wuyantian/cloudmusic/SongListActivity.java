package com.example.wuyantian.cloudmusic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SongListActivity extends AppCompatActivity {
    private List<Song>songList=new ArrayList<>();
    RecyclerView recyclerView;
    SongListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        initSong();
        recyclerView=findViewById(R.id.song_list);
        adapter=new SongListAdapter(songList);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    public void initSong(){
        Song apple=new Song("小苹果",R.drawable.apple_pic);
        Song banana=new Song("小香蕉",R.drawable.banana_pic);
        Song cherry=new Song("小樱桃",R.drawable.cherry_pic);
        Song grape=new Song("小葡萄",R.drawable.grape_pic);
        Song mango=new Song("小芒果",R.drawable.mango_pic);
        Song orange=new Song("小橘子",R.drawable.orange_pic);
        Song pear=new Song("小梨子",R.drawable.pear_pic);
        Song pineapple=new Song("小菠萝",R.drawable.pineapple_pic);
        Song strawberry=new Song("小草莓",R.drawable.strawberry_pic);
        Song watermelon=new Song("小西瓜",R.drawable.watermelon_pic);
        Random random=new Random();
        int length =random.nextInt(50)+1;
        for (int i=0;i<length;i++){
                songList.add(apple);
                songList.add(banana);
                songList.add(cherry);
                songList.add(grape);
                songList.add(mango);
                songList.add(pear);
                songList.add(orange);
                songList.add(pineapple);
                songList.add(strawberry);
                songList.add(watermelon);
        }

    }
}
C   