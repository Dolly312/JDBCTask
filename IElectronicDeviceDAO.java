package com.fis.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.fis.app.exce.NoDeviceFoundException;
import com.fis.app.model.ElectrnoicDevice;

public interface IElectronicDeviceDAO {

	
	public boolean addDevice(ElectrnoicDevice device) throws SQLException;
	public List<ElectrnoicDevice> getAllDevices();
	
	public boolean changeDevicePrice(int deviceId,int newPrice);
	public boolean changeDeviceRating(int deviceId,int newRating);
	
	public boolean deleteDevice(int deviceId);
	
	public List<ElectrnoicDevice> geDevicesBasedOnBrandNameAndType(String brandName,String type);
	public int countDeviceType(String type);
	public int getSumofPriceBasedOnType(String type);
	
	
	
}
