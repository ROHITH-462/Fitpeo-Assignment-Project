package com.fitpeo.AutomationTestAssignment.propertyfileloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLoader {
	
	static PropertyFileLoader instance;
	Properties prop;
	FileInputStream fis;
	
	public String browserName;
	public String chromeDriver;
	public String url;
	
	
	private PropertyFileLoader() throws IOException{
		prop = new Properties();
		fis = new FileInputStream("./src/test/resources/prop.properties");
		prop.load(fis);
		
		browserName = prop.getProperty("Browser");
		chromeDriver = prop.getProperty("Chrome_DriverLocation");
		
		url = prop.getProperty("URL");
	}
	
	public static PropertyFileLoader getInstance() throws IOException {
		if(instance == null)
			instance = new PropertyFileLoader();
		return instance;
	}

}
