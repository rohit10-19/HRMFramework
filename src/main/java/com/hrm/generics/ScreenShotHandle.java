package com.hrm.generics;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hrm.base.Base;

public class ScreenShotHandle extends Base
{
	public static void  screenShotHandle(String imagename)
	{
		Date d = new Date();
		SimpleDateFormat s= new SimpleDateFormat("dd_MM_YYYY");
		String date=s.format(d);
		TakesScreenshot ss=(TakesScreenshot)driver;
		File srcfile=ss.getScreenshotAs(OutputType.FILE);
		File destfile=new File(Autoconstants.screenshotpath+imagename+date+".png");
		try 
		{
			FileUtils.copyFile(srcfile, destfile);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
