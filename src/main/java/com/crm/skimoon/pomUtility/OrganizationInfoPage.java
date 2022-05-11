package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[@class='dvHeaderText']")
    WebElement orgnizationInfoPageTitle;
	
	public WebElement getorgnizationInfoPageTitle()
	{
		return orgnizationInfoPageTitle;
	}

}
