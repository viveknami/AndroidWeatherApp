package com.example.datacontroller.model;


import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CurrentWeatherDb {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_CITY_ZIPCODE = "cityZipcode";
	public static final String KEY_CITY_NAME = "cityName";
	public static final String KEY_TEMP = "temperature";
	public static final String KEY_COND = "condition";
	public static final String KEY_PRESSURE = "pressure";
	public static final String KEY_HUMIDITY = "humidity";
	public static final String KEY_ICON_URL = "iconURL";
	public static final String KEY_LAST_UPDATED_TIME = "lastUpdatedTime";

	public static final String CURRENT_WEATHER_TABLE = "CurrentWeatherTable";

	private static final String CURRENT_WEATHER_DATABASE_CREATE =
			"CREATE TABLE if not exists " + CURRENT_WEATHER_TABLE + " (" +
					KEY_ROWID + " integer PRIMARY KEY autoincrement," +
					KEY_CITY_ZIPCODE + "," +
					KEY_CITY_NAME + "," +
					KEY_TEMP + "," +
					KEY_COND + "," +
					KEY_PRESSURE + "," +
					KEY_HUMIDITY + "," +
					KEY_ICON_URL + "," +
					KEY_LAST_UPDATED_TIME + "," +
					" UNIQUE (" + KEY_CITY_ZIPCODE +"));";

	public static void onCreate(SQLiteDatabase db) {
		Log.d("Vivek", CURRENT_WEATHER_DATABASE_CREATE);
		db.execSQL(CURRENT_WEATHER_DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("Vivek", "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + CURRENT_WEATHER_TABLE);
		onCreate(db);
	}
	
}