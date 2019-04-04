package com.example.wuyantian.cquptcommunity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    //数据源
    private String[] titles = {"头条", "新闻", "娱乐", "体育", "美女", "科技", "财经", "汽车", "彩票", "国际", "推荐",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.tool_bar);
        toolbar.setTitle(null);


        tablayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_paper);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        viewPager.setAdapter(myPagerAdapter);

        tablayout.setupWithViewPager(viewPager);
        tablayout.setTabMode(tablayout.MODE_SCROLLABLE);

        //每条之间的分割线
        LinearLayout linearLayout = (LinearLayout) tablayout.getChildAt(0);

        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);

        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.layout_divider_vertical));


    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        public TestFragment getItem(int position) {
            TestFragment testFragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", titles[position]);
            testFragment.setArguments(bundle);
            return testFragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

}