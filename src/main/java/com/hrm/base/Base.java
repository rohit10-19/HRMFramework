package com.hrm.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.generics.Autoconstants;
import com.hrm.generics.Propertyfilehandle;

public class Base 
{
	public static WebDriver driver;
	public void setBrowser()
	{
		String browsername=Propertyfilehandle.propertyFileHandle("browser");
		if(browsername.equals("Firefox"))
		{
			System.setProperty(Autoconstants.firefoxpath, Autoconstants.firefoxexepath);
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equals("chrome"))
		{
			System.setProperty(Autoconstants.chromedriverpath, Autoconstants.chromedriverexepath);
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Browsername not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(Propertyfilehandle.propertyFileHandle("url"));
	}

}
