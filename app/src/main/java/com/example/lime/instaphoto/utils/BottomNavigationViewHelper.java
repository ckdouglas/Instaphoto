package com.example.lime.instaphoto.utils;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.lime.instaphoto.Home.HomeActivity;
import com.example.lime.instaphoto.Likes.LikesActivity;
import com.example.lime.instaphoto.Profile.ProfileActivity;
import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.Search.SearchActivity;
import com.example.lime.instaphoto.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationView";

    public static void setUpBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG,"Setting Up Botton Navigation Bar");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
        bottomNavigationViewEx.setIconSize(25, 25);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.ic_home:
                        Intent intent1 = new Intent(context,HomeActivity.class);
                                context.startActivity(intent1);
                        break;

                    case R.id.ic_search:
                        Intent intent2 = new Intent(context,SearchActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_add:
                        Intent intent3 = new Intent(context,ShareActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_favorite:
                        Intent intent4 = new Intent(context,LikesActivity.class);
                        context.startActivity(intent4);
                        break;

                    case R.id.ic_profile:
                        Intent intent5 = new Intent(context,ProfileActivity.class);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });
    }
}
