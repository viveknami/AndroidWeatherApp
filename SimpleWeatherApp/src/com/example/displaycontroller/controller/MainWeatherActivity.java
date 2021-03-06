package com.example.displaycontroller.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asyncdataservice.WeatherUpdateAlarm;
import com.example.datacontroller.controller.WeatherDataController;
import com.example.displaycontroller.model.CityLab;
import com.example.simpleweatherapp.R;

public class MainWeatherActivity extends FragmentActivity {

	ViewPager mPager;
	public CityListPagerAdapter mCityPagerAdapter;
	private WeatherDataController mWeatherClient;
	public static String LOG_TAG = "SimpleWeatherApp";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fm = getSupportFragmentManager();
		mPager = (ViewPager) findViewById(R.id.quote_pager);
		mCityPagerAdapter = new CityListPagerAdapter(fm,
				this.getApplicationContext());
		mPager.setAdapter(mCityPagerAdapter);

		// Start Weather Data Controller
		mWeatherClient = WeatherDataController
				.getInstance(getApplicationContext());

		// Start WeatherUpdate periodic alarm
		WeatherUpdateAlarm.scheduleWeatherAlarm(getApplicationContext());

	}

	@Override
	public void onResume() {
		super.onResume();

		int i;
		String lastCity = CityLab.getInstance(getApplicationContext())
				.getLastCity();

		Log.d("SimpleWeatherApp", "OnResume: last city is: " + lastCity);

		if (lastCity == null) {
			Intent intent = new Intent(this, CityManagementActivity.class);
			startActivity(intent);
		} else {

			mCityPagerAdapter.notifyDataSetChanged();
			ArrayList<String> cityList = CityLab.getInstance(
					getApplicationContext()).getCityList();

			for (i = 0; i < cityList.size(); i++) {
				if (((String) cityList.get(i)).equals(lastCity)) {
					mPager.setCurrentItem(i);
					break;
				}

			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_addCity) {
			Intent i = new Intent(this, CityManagementActivity.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
