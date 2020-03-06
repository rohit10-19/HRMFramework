package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.Base;

public class OpenPIMPage extends Base
{
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	private WebElement openpimlink;
	
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']")
	private WebElement addemployeelink;
	
	public OpenPIMPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateOpenPIMPage()
	{
		return driver.getTitle();
		
		
	}
	
	public AddEmployeePage clickOpenPIMPageLink()
	{
		openpimlink.click();
		addemployeelink.click();
		
		return new AddEmployeePage();
	}

}
