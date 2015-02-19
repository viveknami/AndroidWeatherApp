package com.example.datacontroller.controller;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.displaycontroller.model.WeatherData;

public class WeatherJSONParser {

	public static WeatherData getWeather(String data) {
		WeatherData weather = new WeatherData();

		try {
			Log.d("SimpleWeatherApp", "Data [" + data + "]");
			// We create out JSONObject from the data
			JSONObject jObj = new JSONObject(data);

			// Check if it was a bad city name..if yes, then set error string in
			// data and return
			JSONObject errorObserObj = null;
			try {
				errorObserObj = jObj.getJSONObject("response").getJSONObject(
						"error");

			} catch (JSONException ignored) {
			}

			if (errorObserObj != null) {
				
				weather.setErrorString(errorObserObj.getString("description"));
				Log.d("SimpleWeatherApp", "error str is: "  + weather.getErrorString());
				return weather;
			} else {
				weather.setErrorString(null);
			}

			// 1. get current_observation object
			JSONObject currentObserObj = jObj
					.getJSONObject("current_observation");

			// 2. get display_location object from current_observation object
			JSONObject displayLocObj = currentObserObj
					.getJSONObject("display_location");
			weather.location.setCountry(displayLocObj.getString("country"));
			weather.location.setState(displayLocObj.getString("state"));
			weather.location.setCity(displayLocObj.getString("city"));
			weather.location.setLatitude(displayLocObj.getString("latitude"));
			weather.location.setLongitude(displayLocObj.getString("longitude"));

			// 3. get rest of string data from current_observation object

			// 3.a current weather condition
			weather.currentCondition.setWeather(currentObserObj
					.getString("weather"));
			weather.currentCondition.setPressure(currentObserObj
					.getString("pressure_mb"));
			weather.currentCondition.setHumidity(currentObserObj
					.getString("relative_humidity"));
			weather.currentCondition.setIconUrl(currentObserObj
					.getString("icon_url"));

			// 3.b current Temperature
			weather.temperature.setTemp(currentObserObj.getString("temp_f"));

			// 3.c current Wind
			weather.wind.setDetail(currentObserObj.getString("wind_string"));
			weather.wind.setDeg(currentObserObj.getString("wind_degrees"));
			weather.wind.setSpeed(currentObserObj.getString("wind_mph"));
			weather.wind.setDirection(currentObserObj.getString("wind_dir"));

			// 3.d Rain chances
			weather.rain.setPerc(currentObserObj
					.getString("precip_today_string"));

			// 3.e save current time
			
			weather.setLastUpdate(Long.toString(System.currentTimeMillis()));

		} catch (JSONException e) {
			Log.d("SimpleWeatherApp", "1: getWeather failed in JSON pasring");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			Log.d("SimpleWeatherApp", "2: getWeather failed in JSON pasring");
			e.printStackTrace();
			return null;
		}

		return weather;
	}

}
