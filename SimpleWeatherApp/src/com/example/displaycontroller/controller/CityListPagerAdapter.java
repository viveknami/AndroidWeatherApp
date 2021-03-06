package com.example.displaycontroller.controller;

import com.example.displaycontroller.model.CityLab;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class CityListPagerAdapter extends FragmentStatePagerAdapter {
	
	private Context mContext;
	
	public CityListPagerAdapter(FragmentManager fm, Context ctx) {
		super(fm);
		mContext = ctx;
	}
	
	@Override
	public int getCount() {
		return CityLab.getInstance(mContext).getCityList().size();
	}
	
	public int getItemPosition(Object object) {
	    return POSITION_NONE;
	}
	
	@Override
	public Fragment getItem(int position) {
        String city_name = CityLab.getInstance(mContext).getCityList().get(position);
		return new CurrentWeatherFragment(city_name, this);
     }

}
