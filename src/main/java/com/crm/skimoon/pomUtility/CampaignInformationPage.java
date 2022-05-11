package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage 
{
	WebDriver driver;
	public CampaignInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement campaignInfotitle;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignInfotitle() {
		return campaignInfotitle;
	}
}
