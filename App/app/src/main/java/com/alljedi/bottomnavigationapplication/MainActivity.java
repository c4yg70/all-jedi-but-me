package com.alljedi.bottomnavigationapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.alljedi.bottomnavigationapplication.Content.RecommendCardContent;
import com.alljedi.bottomnavigationapplication.Fragment.FavouriteFragment;
import com.alljedi.bottomnavigationapplication.Fragment.FollowFragment;
import com.alljedi.bottomnavigationapplication.Fragment.JournalFragment;
import com.alljedi.bottomnavigationapplication.Fragment.ProfileFragment;
import com.alljedi.bottomnavigationapplication.Fragment.RecommendCardFragment;
import com.alljedi.bottomnavigationapplication.Fragment.StarFragment;
import com.alljedi.bottomnavigationapplication.Fragment.TextFragment;
import com.alljedi.bottomnavigationapplication.View.CustomViewPager;
import com.beardedhen.androidbootstrap.TypefaceProvider;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RecommendCardFragment.OnListFragmentInteractionListener {
    private CustomViewPager viewPager;

    private TextFragment textFragment = new TextFragment();
    private ProfileFragment profileFragment = new ProfileFragment();
    private FavouriteFragment favouriteFragment;
    private StarFragment starFragment = new StarFragment();
    private FollowFragment followFragment = new FollowFragment();
    private JournalFragment journalFragment;
    private RecommendCardFragment recommendCardFragment = new RecommendCardFragment();
    BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //点击BottomNavigationView的Item项，切换ViewPager页面
            //menu/navigation.xml里加的android:orderInCategory属性就是下面item.getOrder()取的值
            viewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_main);
        viewPager = (CustomViewPager) findViewById(R.id.view_pager);
        viewPager.setScanScroll(false);
        viewPager.addOnPageChangeListener(this);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:

                        return textFragment;
                    case 1:
                        return followFragment;
                    case 2:
                        //recommendCardFragment ;
                        return recommendCardFragment;
                    case 3:
                        //starFragment = new StarFragment();
                        return starFragment;
                    case 4:

                        return profileFragment;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //页面滑动的时候，改变BottomNavigationView的Item高亮
        navView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onListFragmentInteraction(RecommendCardContent.RecommendCardItem item){

    }


}
