package com.pawan.whatsAppCleaner.tabs;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.pawan.whatsAppCleaner.DataHolder;
import com.pawan.whatsAppCleaner.R;

public class TabLayoutActivity_test extends AppCompatActivity {
    private static OnTabListener mOnTabListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);
        String category = getIntent().getStringExtra("category");
        TabsAdapter_test tabsAdapter_test;

        switch (category) {
            default:
            case DataHolder.STATUS:
                tabsAdapter_test = new TabsAdapter_test(getSupportFragmentManager(), DataHolder.STATUS, DataHolder.statuscache, DataHolder.statusdownload);
                break;
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (mOnTabListener != null){
                    mOnTabListener.ontablistener(tab); }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.setAdapter(tabsAdapter_test);

        tabLayout.setupWithViewPager(viewPager);
    }
    public static void setmOnTabListener(OnTabListener onTabListener) {
        mOnTabListener = onTabListener;
    }


    public interface OnTabListener {
        void ontablistener(TabLayout.Tab tab);
    }

}

