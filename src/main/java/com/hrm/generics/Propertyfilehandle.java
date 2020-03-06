package com.hrm.generics;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertyfilehandle 
{
	public static String propertyFileHandle(String key)
	{
		Properties prop= new Properties();
		
		try 
		{
			prop.load(new FileInputStream(Autoconstants.propertyfilepath));
		}
		catch (Exception e) 
		{
			
		} 
		
		return prop.getProperty(key);
	}

}
