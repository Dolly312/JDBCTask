package com.fis.app.model;

public class ElectrnoicDevice {
	
	private String deviceType;
	private int deviceId;
	private String brandName;
	private int cost;
	private int power;
	public ElectrnoicDevice(String deviceType, int deviceId, String brandName,
			int cost, int power, int starRatings, String color) {
		super();
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.brandName = brandName;
		this.cost = cost;
		this.power = power;
		this.starRatings = starRatings;
		this.color = color;
	}
	public ElectrnoicDevice() {
		// TODO Auto-generated constructor stub
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getStarRatings() {
		return starRatings;
	}
	public void setStarRatings(int starRatings) {
		this.starRatings = starRatings;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	private int starRatings;
	private String color;
	
	
	

}
