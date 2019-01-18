package com.example.lime.instaphoto.Home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.utils.BottomNavigationViewHelper;
import com.example.lime.instaphoto.utils.SectionPagerAdapter;
import com.example.lime.instaphoto.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "Home Activity";
    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG,"onCreate Starting");
        initializeImageLoader();
        setUpBottonNavigationView();
        setUpViewPager();
    }

    private void initializeImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    private void setUpViewPager(){
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new CameraFragment());
        sectionPagerAdapter.addFragment(new HomeFragment());
        sectionPagerAdapter.addFragment(new MessageFragment());
        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(sectionPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_home);

    }

    private void setUpBottonNavigationView() {
        Log.d(TAG,"Setting Up Bottom Navigation Bar");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottonNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }

}
