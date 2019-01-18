package com.example.lime.instaphoto.utils;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer > mFragment = new HashMap<>();
    private final HashMap<String, Integer > mFragmentNumber = new HashMap<>();
    private final HashMap<Integer, String > mFragmentName = new HashMap<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void  addFragment(Fragment fragment, String fragmentName){
        mFragmentList.add(fragment);
        mFragment.put(fragment, mFragmentList.size()-1);
        mFragmentNumber.put(fragmentName, mFragmentList.size()-1);
        mFragmentName.put(mFragmentList.size()-1, fragmentName);
    }

/**
 * return fragment number
 * @param fragmentName
 * @return
 */

    public Integer getFragmentNumber(String fragmentName){
        if (mFragmentNumber.containsKey(fragmentName))
            return mFragmentNumber.get(fragmentName);
        return null;
    }
    /**
     * return fragment number
     * @param fragment
     * @return
     */
    public Integer getFragmentNumber(Fragment fragment){
        if (mFragmentNumber.containsKey(fragment))
            return mFragmentNumber.get(fragment);
        return null;
    }
    /**
     * return fragment number
     * @param fragmentNumber
     * @return
     */
    public String getFramenentName(Integer fragmentNumber){
        if (mFragmentName.containsKey(fragmentNumber))
            return mFragmentName.get(fragmentNumber);
        return null;
    }
}
