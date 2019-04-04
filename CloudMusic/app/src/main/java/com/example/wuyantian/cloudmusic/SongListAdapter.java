package com.example.wuyantian.cloudmusic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter <SongListAdapter.ViewHolder> {
private List<Song>songList;

    public SongListAdapter(List<Song>songs) {
        songList=songs;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView songImage;
        TextView songName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songImage=itemView.findViewById(R.id.song_image);
            songName=itemView.findViewById(R.id.song_name);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Song song=songList.get(i);
        viewHolder.songName.setText(song.getName());
        viewHolder.songImage.setImageResource(song.getImageId());

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
