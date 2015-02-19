package com.example.asyncdataservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootUpCompletedReceiver extends BroadcastReceiver{

  @Override
  public void onReceive(Context context, Intent intent)
  {
	  WeatherUpdateAlarm.scheduleWeatherAlarm(context); 
  }
	
}
