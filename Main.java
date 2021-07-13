package com.fis.app.dao;

import java.util.List;

import com.fis.app.model.ElectrnoicDevice;



public class Main {
   public static void main(String[] args) {
	try
	{
		IElectronicDeviceDAO e = new ElectronicDeviceDAO();
		/*ElectrnoicDevice d = new ElectrnoicDevice("Mobile",1234,"vivo",30500,4000,4,"Black");
		
		
		boolean a = e.addDevice(d);
		System.out.println(a);*/
		List<ElectrnoicDevice> list = e.getAllDevices();
		
		list.stream().forEach((dev)->System.out.println(dev));
		
	}
	catch (Exception e) {
		System.out.println(" Problem "+e);
	}
}
}
