package com.example.displaycontroller.controller;


import java.util.List;

import com.example.displaycontroller.model.CityLab;
import com.example.simpleweatherapp.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CityListAdapter extends ArrayAdapter<String> {

	private List<String> mCityList;
	private Activity mActivity;

	public CityListAdapter(List<String> cities, Activity activity) {
		super(activity, R.layout.city_listview_item, cities);
		mCityList = cities;
		mActivity = activity;
	}

	@Override
	public int getCount() {
		return mCityList.size();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mActivity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.city_listview_item, parent,
					false);
			
			ViewHolder holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		
		}

		ViewHolder holder = (ViewHolder) convertView.getTag();
		holder.position = position;
		
		holder.mCityTextView.setText((String) getItem(position));
		holder.mCheckBox.setChecked(true);

		convertView.setOnClickListener(new TextView.OnClickListener() {
			@Override
			public void onClick(View v) {
				CityLab.getInstance(mActivity.getApplicationContext()).setLastCity(mCityList.get(position));
			    mActivity.finish();	
			}
		});

		holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String city_name = mCityList.get(position);				
				String lastCity = CityLab.getInstance(mActivity.getApplicationContext()).getLastCity();
				if (lastCity.equals(city_name)) {
					mCityList.remove(position);
					if(mCityList.size() > 0) {
					   CityLab.getInstance(mActivity.getApplicationContext()).setLastCity(mCityList.get(0));
					}
				} else {
					mCityList.remove(position);
				}

				CityLab.getInstance(mActivity.getApplicationContext()).removeCity(city_name);
				notifyDataSetChanged();

			}
		});
		
		return convertView;
	}
	
	private class ViewHolder {
		
		TextView mCityTextView;
		CheckBox mCheckBox;
		int position;
		
		private ViewHolder(View v) {
			mCityTextView  = (TextView) v.findViewById(R.id.cityName);
			mCheckBox = (CheckBox) v.findViewById(R.id.checkbox1);
			
		}
 	}

}
