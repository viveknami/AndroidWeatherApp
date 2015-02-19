package com.example.asyncdataservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WeatherUpdateAlarmBroadcastReceiver extends BroadcastReceiver {

	public static int REQUEST_CODE = 12345;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		 Log.d("Vivek", "WeatherUpdateAlarmBroadcastReceiver OnReceive is called");
		 Intent serviceIntent = new Intent(context, WeatherIntentService.class);
		 context.startService(serviceIntent); 

	}
}
