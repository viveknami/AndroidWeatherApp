package com.example.asyncdataservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class WeatherUpdateAlarm {

	private static long WEATHER_UPDATE_ALARM = 1000 * 60 * 20;  // 20 mins 
	
	public static void scheduleWeatherAlarm(Context ctx) {
		
		Intent intent = new Intent(ctx, WeatherUpdateAlarmBroadcastReceiver.class);
		// Create a PendingIntent to be triggered when the alarm goes off
		final PendingIntent pIntent = PendingIntent.getBroadcast(ctx, WeatherUpdateAlarmBroadcastReceiver.REQUEST_CODE,
				intent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		// Setup periodic alarm every 20 minutes
		long firstMillis = System.currentTimeMillis(); // first run of alarm is immediate
		long intervalMillis = WEATHER_UPDATE_ALARM; // 20 minute
		AlarmManager alarm = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
		alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, intervalMillis, pIntent);
	}
}
