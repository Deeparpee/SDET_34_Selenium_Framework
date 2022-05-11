package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	WebDriver driver;
	public OpportunityInfoPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[@class='dvHeaderText']")
    WebElement opportunityInfoPageTitle;
	
	public WebElement getopportunityInfoPageTitle()
	{
		return opportunityInfoPageTitle;
	}

}
