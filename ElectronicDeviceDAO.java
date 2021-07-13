package com.fis.app.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import p1.TestCon;

import com.fis.app.exce.NoDeviceFoundException;
import com.fis.app.model.ElectrnoicDevice;

public class ElectronicDeviceDAO implements IElectronicDeviceDAO {
	Connection con = null;

	String insertEmployeeQuery = "insert into electronicdevice.device values(?,?,?,?,?,?,?)";
	String selectAllEmployees = "select * from electronicdevice.device";
	String selectEmployeeBasedOnBrandandType = "select * from electronicdevice.device where brandName = ? and deviceType=?";
	 String UpdateQuery = "update electronicdevice.device set price=? where deviceid=?";
	 String UpdateQueryRating = "update electronicdevice.device set rating=? where deviceid=?";
	 String DeleteQuery = "DELETE FROM electronicdevice.device WHERE id = ?";
	 String CountQuery = "select count(deviceType) as total from electronicdevice.device ";
	 String SumQuery="select sum(price) as total electronicdevice.device";
	@Override
	public boolean addDevice(ElectrnoicDevice d) throws SQLException {
		
		con = TestCon.getConnection();
		boolean isInserted = false;
		if (con != null) {

			// Step1 : extract employee details from e object
			String deviceType = d.getDeviceType();
			int deviceId = d.getDeviceId();
			String brandName= d.getBrandName();
			int cost=d.getCost();
			int power=d.getPower();
			int Rating=d.getStarRatings();
			String color = d.getColor();
			

			// Step 2 :- write the code to create complete insert Query with data
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(insertEmployeeQuery);
				ps.setString(1, deviceType);
				ps.setInt(2, deviceId);
				ps.setString(3, brandName);
				ps.setInt(4, cost);
				ps.setInt(5, power);
				ps.setInt(6, Rating);
				ps.setString(7, deviceType);
				int i = ps.executeUpdate(); // only works with insert , update & delete

				if (i > 0)
					isInserted = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

			// Step 3 : execute Query
			

		}

		return isInserted;
		
	}

	
	
	
	
	
	@Override
	public List<ElectrnoicDevice> getAllDevices() {
		con = TestCon.getConnection();
		List<ElectrnoicDevice> deviceList = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps;
			try {
				ps = con.prepareStatement(selectAllEmployees);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					ElectrnoicDevice temp = new ElectrnoicDevice(); // default emp,

					temp.setDeviceType(rs.getString("DeviceType"));
					temp.setDeviceId(rs.getInt(""));
					temp.setBrandName(rs.getString("BrandName"));
					temp.setPower(rs.getInt("Power"));
					temp.setCost(rs.getInt("cost"));
					temp.setStarRatings(rs.getInt("Ratings"));
					temp.setColor(rs.getString("Color"));
					
					

					deviceList.add(temp);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		return deviceList;
	}	
	

	
	
	
	
	@Override
	public boolean changeDevicePrice(int deviceId, int newPrice) {
		con = TestCon.getConnection();
		boolean isUpdated=false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UpdateQueryRating);
			
			if(con!=null)
			{
				ps.setInt(1,  deviceId);
				ps.setInt(2, newPrice);
				int i=ps.executeUpdate();
				System.out.println("i"+i);
				if(i>0)
					isUpdated=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}
		
	
	
	

	@Override
	public boolean changeDeviceRating(int deviceId, int newRating) {
		con = TestCon.getConnection();
		boolean isUpdated=false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UpdateQueryRating);
			
			if(con!=null)
			{
				ps.setInt(1,  deviceId);
				ps.setInt(2, newRating);
				int i=ps.executeUpdate();
				System.out.println("i"+i);
				if(i>0)
					isUpdated=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
	}
	
	
	

	@Override
	public boolean deleteDevice(int deviceId) {
		con = TestCon.getConnection();
		boolean isUpdated=false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(DeleteQuery);
			
			if(con!=null)
			{
				ps.setInt(1,  deviceId);
				ps.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdated;
		
	}

	
	
	
	@Override
	public List<ElectrnoicDevice> geDevicesBasedOnBrandNameAndType(
			String brandName, String type) {
		con = TestCon.getConnection();
		ElectrnoicDevice d1 = null;
		if (con != null) {

			PreparedStatement ps;
			try {
				ps = con.prepareStatement(selectEmployeeBasedOnBrandandType);
				ps.setString(1, brandName);
				ps.setString(1, type);

				ResultSet rs = ps.executeQuery();
				boolean isFound = false;
				while (rs.next()) {
					isFound = true;
					ElectrnoicDevice temp = new ElectrnoicDevice(); // default emp,

					temp.setDeviceType(rs.getString("DeviceType"));
					temp.setDeviceId(rs.getInt(""));
					temp.setBrandName(rs.getString("BrandName"));
					temp.setPower(rs.getInt("Power"));
					temp.setCost(rs.getInt("cost"));
					temp.setStarRatings(rs.getInt("Ratings"));
					temp.setColor(rs.getString("Color"));
					
					

					((List<ElectrnoicDevice>) d1).add(temp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		return ((List<ElectrnoicDevice>) d1);
	}

	@Override
	public int countDeviceType(String type) {
		con = TestCon.getConnection();
		int i = 0;
		boolean isUpdated=false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(CountQuery);
			
			if(con!=null)
			{
				ps.setString(1,type);
				
				i=ps.executeUpdate();
				System.out.println("i"+i);
				if(i>0)
					isUpdated=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	

	@Override
	public int getSumofPriceBasedOnType(String type) {
		con = TestCon.getConnection();
		int i = 0;
		boolean isUpdated=false;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(CountQuery);
			
			if(con!=null)
			{
				
				i=ps.executeUpdate();
				System.out.println("i"+i);
				if(i>0)
					isUpdated=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}
