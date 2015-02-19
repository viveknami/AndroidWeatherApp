package com.example.displaycontroller.model;

import java.io.Serializable;

import android.graphics.Bitmap;

public class WeatherData implements Serializable {


	public Location location = new Location();
	public Condition currentCondition = new Condition();
	public Temperature temperature = new Temperature();
	public Wind wind = new Wind();
	public Rain rain = new Rain();
	
	public Bitmap iconBitmap;
	private String lastUpdate;
	private String ErrorString;
	private Boolean isUpdating;
	

	public Boolean getIsUpdating() {
		return isUpdating;
	}

	public void setIsUpdating(Boolean isUpdating) {
		this.isUpdating = isUpdating;
	}

	public Bitmap getIconBitmap() {
		return iconBitmap;
	}

	public void setIconBitmap(Bitmap iconBitmap) {
		this.iconBitmap = iconBitmap;
	}

	public String getErrorString() {
		return ErrorString;
	}

	public void setErrorString(String errorString) {
		ErrorString = errorString;
	}
	
	
	public class Location implements Serializable {

		private String longitude;
		private String latitude;

		private String country;
		private String state;
		private String city;
		private String cityZipcode;

		public String getCityZipcode() {
			return cityZipcode;
		}

		public void setCityZipcode(String cityZipcode) {
			this.cityZipcode = cityZipcode;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

	}

	public class Condition implements Serializable {

		private String weather; // current weather condition
		private String pressure;
		private String humidity;
		private String iconUrl;

		public String getWeather() {
			return weather;
		}

		public void setWeather(String weather) {
			this.weather = weather;
		}

		public String getPressure() {
			return pressure;
		}

		public void setPressure(String pressure) {
			this.pressure = pressure;
		}

		public String getHumidity() {
			return humidity;
		}

		public void setHumidity(String humidity) {
			this.humidity = humidity;
		}

		public String getIconUrl() {
			return iconUrl;
		}

		public void setIconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
		}

	}

	public class Temperature implements Serializable{
		private String temp;
		private String minTemp;
		private String maxTemp;

		public String getTemp() {
			return temp;
		}

		public void setTemp(String temp) {
			this.temp = temp;
		}

		public String getMinTemp() {
			return minTemp;
		}

		public void setMinTemp(String minTemp) {
			this.minTemp = minTemp;
		}

		public String getMaxTemp() {
			return maxTemp;
		}

		public void setMaxTemp(String maxTemp) {
			this.maxTemp = maxTemp;
		}

	}

	public class Wind implements Serializable {

		private String detail;
		private String speed;
		private String deg;
		private String direction;

		public String getSpeed() {
			return speed;
		}

		public void setSpeed(String speed) {
			this.speed = speed;
		}

		public String getDeg() {
			return deg;
		}

		public void setDeg(String deg) {
			this.deg = deg;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getDirection() {
			return direction;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}

	}

	public class Rain implements Serializable {
		private String perc;

		public String getPerc() {
			return perc;
		}

		public void setPerc(String perc) {
			this.perc = perc;
		}

	}

	public void setLastUpdate(String str) {
		lastUpdate = str;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

}
