package com.example.lime.instaphoto.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.utils.BottomNavigationViewHelper;
import com.example.lime.instaphoto.utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate Started");
        setUpActivityWidgets();
        //setProfileImage();
        setUpToolBar();
        setUpBottonNavigationView();
    }

    private void setUpToolBar(){

        final Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.profilePreferences:
                            Log.d(TAG, "Profile Preferences Clicked");
                            Intent intent = new Intent(ProfileActivity.this, AccountSettingsActivity.class);
                            startActivity(intent);
                        break;

                        case R.id.profileAbout:
                            Log.d(TAG, "Profile About Clicked");
                        break;
                    }
                    return false;
                }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return true;
    }

    private void setProfileImage(){
        //String imageUrl = "https://classic105.s3.amazonaws.com/wp-content/uploads/2017/09/vann.jpg";
        String imageUrl= "";
        UniversalImageLoader.setImage(imageUrl,mImageView,null,null);
    }
    private void setUpActivityWidgets(){
        mImageView = (ImageView) findViewById(R.id.profile_picture);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

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
