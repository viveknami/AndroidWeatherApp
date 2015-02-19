package com.example.displaycontroller.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class CityLab {
	private static CityLab sCityLab;
	private static SharedPreferences sharedpreferences;
	public static final String CityPREFERENCES = "CityPrefs";
	public static final String LastCity = "lastCity";
	public static final String CityList = "cityList";


	public static CityLab getInstance(Context ctx) {
		if (sCityLab == null) {
			sCityLab = new CityLab();
			sharedpreferences = ctx.getSharedPreferences(CityPREFERENCES,
					Context.MODE_PRIVATE);
		}
		return sCityLab;
	}

	public void setLastCity(String city) {
		sharedpreferences.edit().putString(LastCity, city).commit();
	}

	public String getLastCity() {
		return sharedpreferences.getString(LastCity, null);
	}

	public ArrayList<String> getCityList() {
		String cityListString = sharedpreferences.getString(CityList, null);

		if (cityListString == null) {
			return new ArrayList<String>();
		} else {
			String[] cityArray = cityListString.split(",");
			ArrayList<String> cityList = new ArrayList<String>(
					Arrays.asList(cityArray));
			return cityList;
		}
	}


	public void addNewCity(String city_name) {

		List<String> cityList = getCityList();
		cityList.add(city_name);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cityList.size(); i++) {
			sb.append(cityList.get(i)).append(",");
		}

		sharedpreferences.edit().putString(CityList, sb.toString()).commit();

	}

	public void removeCity(String city_name) {

		List<String> cityList = getCityList();
		cityList.remove(city_name);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cityList.size(); i++) {
			sb.append(cityList.get(i)).append(",");
		}

		sharedpreferences.edit().putString(CityList, sb.toString()).commit();

	}

}
