package com.hrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Base;

public class LoginPage extends Base 
{
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement loginbutton;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		 return driver.getTitle();
	}
	
	public   OpenPIMPage setCredentials(String un, String pwd)
	{
	 username.sendKeys(un);
	 password.sendKeys(pwd);
	 loginbutton.click();
	 
	 return new OpenPIMPage();
	}

}
