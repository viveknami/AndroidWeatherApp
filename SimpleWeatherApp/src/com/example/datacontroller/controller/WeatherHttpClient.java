package com.example.datacontroller.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;

import com.example.displaycontroller.model.WeatherData;

public class WeatherHttpClient {

	static String BASE_URL = "http://api.wunderground.com/api/YOUR_API_KEY/conditions/q/";

	public WeatherData remoteWeatherFetch(String location) {
		HttpURLConnection con = null;
		InputStream is = null;
		String weatherString;
		WeatherData data = null;

		try {
			String url = BASE_URL + location + ".json";

			con = (HttpURLConnection) (new URL(url)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();

			// Let's read the response
			StringBuffer buffer = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null)
				buffer.append(line + "\r\n");

			is.close();
			con.disconnect();

			weatherString = buffer.toString();
			data = WeatherJSONParser.getWeather(weatherString);
			
			//set City ZIp code to weatherdata
            data.location.setCityZipcode(location);

		} catch (Exception e) {
			Log.d("SimpleWeatherApp", "remoteWeatherFetch failed in remote connection");
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Exception e) {
			}
			try {
				con.disconnect();
			} catch (Exception e) {
			}
		}

		return data;
	}
}
