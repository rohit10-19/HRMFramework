package com.hrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.base.Base;
import com.hrm.generics.Propertyfilehandle;
import com.hrm.pages.LoginPage;
import com.hrm.pages.OpenPIMPage;

public class OpenPIMPageTest extends Base
{
	LoginPage loginpage;
	OpenPIMPage openpimpage;
	
	@BeforeMethod
	
	public void setUp()
	{
		setBrowser();
		
		loginpage=new LoginPage();
		openpimpage=loginpage.setCredentials(Propertyfilehandle.propertyFileHandle("username"),Propertyfilehandle.propertyFileHandle("password"));
	}
	
	@Test(priority=1)
	
	public void validateOpenPIMPageTitleTest()
	{
		String title = openpimpage.validateOpenPIMPage();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	
	public void clickTest()
	{
		openpimpage.clickOpenPIMPageLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
