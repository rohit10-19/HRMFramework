package com.hrm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.base.Base;
import com.hrm.generics.ExcelReader;
import com.hrm.generics.Propertyfilehandle;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.OpenPIMPage;

public class AddEmployeePageTest extends Base
{
	LoginPage loginpage;
	OpenPIMPage openpimpage;
	AddEmployeePage addemployeepage;
	String sheetname="Sheet1";
	
	@BeforeMethod
	
	public void setUp()
	{
        
		setBrowser();
		
		loginpage=new LoginPage();
		openpimpage=loginpage.setCredentials(Propertyfilehandle.propertyFileHandle("username"),Propertyfilehandle.propertyFileHandle("password"));
		addemployeepage=openpimpage.clickOpenPIMPageLink();
	}
	
	@Test(priority=1)
	
	public void validateAddEmployeePageTest()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	/*@Test(priority=2)
	public void fillData()
	{
		String firstname = ExcelReader.readExcelFile("Sheet1", 1, 0);
		String lastname = ExcelReader.readExcelFile("Sheet1", 1, 1);
		String username = ExcelReader.readExcelFile("Sheet1", 1, 2);
		String password = ExcelReader.readExcelFile("Sheet1", 1, 3);
		String repassword = ExcelReader.readExcelFile("Sheet1", 1, 4);
		addemployeepage.setCredentials(firstname, lastname, username, password, repassword);
		
	}*/
	
	@DataProvider
	
	public Object[][] data()
	{
		int rowcount = ExcelReader.getLastRowCount("Sheet1");
		System.out.println(rowcount);
		int cellcount = ExcelReader.getLastCellCount("Sheet1", rowcount);
		System.out.println(cellcount);
		Object[][] ref = new String[rowcount][5];
		for(int i=0;i<rowcount;i++)
		{
			ref[i][0]=ExcelReader.readExcelFile("Sheet1",i+1, 0);
			ref[i][1]=ExcelReader.readExcelFile("Sheet1",i+1, 1);
			ref[i][2]=ExcelReader.readExcelFile("Sheet1",i+1, 2);
			ref[i][3]=ExcelReader.readExcelFile("Sheet1",i+1, 3);
			ref[i][4]=ExcelReader.readExcelFile("Sheet1",i+1, 4);
			
		}
		return ref;
		
		
	}
	
	@Test(dataProvider="data")
	public void fillData(String FirstName, String LastName, String UserName, String Password, String RePassword)
	{
		addemployeepage.setCredentials(FirstName, LastName, UserName, Password, RePassword);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
