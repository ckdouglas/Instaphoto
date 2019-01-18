package com.example.lime.instaphoto.Search;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchHelper";
    private Context mContext = SearchActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate Started");
        setUpBottonNavigationView();
}

    private void setUpBottonNavigationView() {
        Log.d(TAG,"Setting Up Bottom Navigation Bar");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottonNavViewBar);
        BottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
    }
}
