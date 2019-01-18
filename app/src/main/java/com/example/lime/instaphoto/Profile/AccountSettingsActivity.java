package com.example.lime.instaphoto.Profile;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.utils.BottomNavigationViewHelper;
import com.example.lime.instaphoto.utils.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private String TAG = "Activity Acc Settings";
    Context mContext = AccountSettingsActivity.this;
    private SectionStatePagerAdapter sectionStatePagerAdapter;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        viewPager = (ViewPager) findViewById(R.id.container);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        setUpBottonNavigationView();
        setUpSettingsList();
        setUpFragments();
    }


    private void setUpSettingsList(){
       ListView listView = (ListView) findViewById(R.id.listViewAccountSetting);
       ArrayList<String> options = new ArrayList<>();

       options.add(getString(R.string.edit_profile));
       options.add(getString(R.string.sign_out));

       ArrayAdapter arrayAdapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1,options);
       listView.setAdapter(arrayAdapter);

       ImageView imageView = (ImageView) findViewById(R.id.backArrow);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.d(TAG, "navigating to fragment "+ position);
               setViewPager(position);
           }
       });
    }


    private void setUpFragments(){
        sectionStatePagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        sectionStatePagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile));
        sectionStatePagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));
    }

    private void setViewPager(int fragmentNumber){
        Log.d(TAG, "Navigating To Fragment Number "+ fragmentNumber);
        relativeLayout.setVisibility(View.GONE);
        viewPager.setAdapter(sectionStatePagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setUpBottonNavigationView() {
        Log.d(TAG,"Setting Up Bottom Navigation Bar");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottonNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);
    }
}

