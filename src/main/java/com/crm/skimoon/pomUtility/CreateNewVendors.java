package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendors 
{
	WebDriver driver;
	public CreateNewVendors(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorNameEditBox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVendorNameEditBox() {
		return vendorNameEditBox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createNewVendor(String vedorName)
	{
		vendorNameEditBox.sendKeys(vedorName);
		savebtn.click();
	}

}
