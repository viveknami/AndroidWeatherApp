package com.example.datacontroller.model;

import com.example.displaycontroller.model.WeatherData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "MyDatabase";
	private static final int DATABASE_VERSION = 1;
	private static Context sContext;

	DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		sContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("Vivek", "Create table in database");
		CurrentWeatherDb.onCreate(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		CurrentWeatherDb.onUpgrade(db, oldVersion, newVersion);
	}
	
	
	public static void updateWeatherDataToDB(WeatherData data) {

		ContentValues values = new ContentValues();
		values.put(CurrentWeatherDb.KEY_CITY_ZIPCODE,
				data.location.getCityZipcode());
		values.put(CurrentWeatherDb.KEY_CITY_NAME, data.location.getCity());
		values.put(CurrentWeatherDb.KEY_TEMP, data.temperature.getTemp());
		values.put(CurrentWeatherDb.KEY_COND,
				data.currentCondition.getWeather());
		values.put(CurrentWeatherDb.KEY_PRESSURE,
				data.currentCondition.getPressure());
		values.put(CurrentWeatherDb.KEY_HUMIDITY,
				data.currentCondition.getHumidity());
		values.put(CurrentWeatherDb.KEY_ICON_URL,
				data.currentCondition.getIconUrl());
		values.put(CurrentWeatherDb.KEY_LAST_UPDATED_TIME, data.getLastUpdate());

		sContext.getContentResolver().insert(
				WeatherContentProvider.CONTENT_CURRWEATHER_URI, values);
	}

	
	public static WeatherData getCachedWeatherFromDB(String location) {

		WeatherData data = null;
		// Query content provider:
		String mSelectionClause = CurrentWeatherDb.KEY_CITY_ZIPCODE + " = ?";

		// Moves the user's input string to the selection arguments.
		String[] mSelectionArgs = { "" };
		mSelectionArgs[0] = location;

		Cursor c = sContext.getContentResolver().query(
				WeatherContentProvider.CONTENT_CURRWEATHER_URI, null,
				mSelectionClause, mSelectionArgs, "");
		if (!c.moveToFirst()) {
			Log.d("Vivek", "Nothing in content provider");
		} else {
			data = new WeatherData();
			data.location.setCity(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_CITY_NAME)));
			data.temperature.setTemp(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_TEMP)));
			data.currentCondition.setWeather(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_COND)));
			data.currentCondition.setPressure(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_PRESSURE)));
			data.currentCondition.setHumidity(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_HUMIDITY)));
			data.currentCondition.setIconUrl(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_ICON_URL)));
			data.setLastUpdate(c.getString(c
					.getColumnIndex(CurrentWeatherDb.KEY_LAST_UPDATED_TIME)));
		}

		return data;
	}

}