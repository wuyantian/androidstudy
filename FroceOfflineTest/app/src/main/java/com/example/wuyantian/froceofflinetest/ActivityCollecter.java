package com.example.wuyantian.froceofflinetest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollecter {
    private static List<Activity>activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void FinishAll(){
        for (Activity activity:activities
             ) {
        if (!activity.isFinishing() ){
            activity.finish();
        }

        }
        activities.clear();

    }
}
