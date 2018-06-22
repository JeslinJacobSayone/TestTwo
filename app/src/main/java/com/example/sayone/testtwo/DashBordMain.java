package com.example.sayone.testtwo;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DashBordMain extends AppCompatActivity implements OnFragmentInteractionListener{

    private final String[] PAGE_TITLES = new String[] {
            "My Grid",
            "My List"
    };


    private final Fragment[] PAGES = new Fragment[] {
            new GridFrag(),
            new ListFrag()
    };

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_bord_main);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<PAGE_TITLES.length;i++){

            tabLayout.getTabAt(i).setText(PAGE_TITLES[i]);
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }
    }
}
