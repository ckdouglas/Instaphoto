package com.example.lime.instaphoto.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lime.instaphoto.R;
import com.example.lime.instaphoto.utils.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static String TAG = "Edit Profile Fragment";
    private ImageView imageView;
    private ImageView backArrow;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_edit_profile,container, false);
        imageView = (ImageView) view.findViewById(R.id.profile_picture);
        backArrow = (ImageView) view.findViewById(R.id.backArrow);
        //setProfileImage();
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().finish();
            }
        });
        return view;
    }

    //TODO: check this method is setProfile Image it causes the application to crush
    private void setProfileImage(){
        Log.d(TAG+":setProfileImage:","setting Up Profile Image");
        //String imageUrl = "https://classic105.s3.amazonaws.com/wp-content/uploads/2017/09/vann.jpg";
        String imageUrl= "";
        UniversalImageLoader.setImage(imageUrl,imageView,null,null);
    }
}
