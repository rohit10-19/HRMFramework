package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Base;

public class AddEmployeePage extends Base
{
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	private WebElement addemployee;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='chkLogin']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@id='user_name']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='user_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='re_password']")
	private WebElement repassword;
	
	@FindBy(xpath="//input[@id='btnSave']")
	private WebElement savebutton;
	
	
	public AddEmployeePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddEmployeePage()
	{
		 return  driver.getTitle();
	}
	
	public void setCredentials(String FirstName, String LastName, String UserName, String Password, String RePassword)
	{
		firstname.sendKeys(FirstName);
		lastname.sendKeys(LastName);
		checkbox.click();
		username.sendKeys(UserName);
		password.sendKeys(Password);
		repassword.sendKeys(RePassword);
		savebutton.click();
	}

}
