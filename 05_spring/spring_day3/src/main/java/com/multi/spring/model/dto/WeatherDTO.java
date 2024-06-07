package com.multi.spring.model.dto;

public class WeatherDTO {
	private int id;
	private String lat;
	private String lon;
	private String weather;
	private String wind;
	private String feels;
	private String cloud;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getFeels() {
		return feels;
	}
	public void setFeels(String feels) {
		this.feels = feels;
	}
	public String getCloud() {
		return cloud;
	}
	public void setCloud(String cloud) {
		this.cloud = cloud;
	}
	@Override
	public String toString() {
		return "WeatherDTO [id=" + id + ", lat=" + lat + ", lon=" + lon + ", weather=" + weather + ", wind=" + wind
				+ ", feels=" + feels + ", cloud=" + cloud + "]";
	}
	
	
	
}
