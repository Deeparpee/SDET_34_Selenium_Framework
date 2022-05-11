package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage 
{
	WebDriver driver;
	public VendorsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVedorsImg;
	
	@FindBy(name="search_text")
	private WebElement searchBoxEdit;
	
	@FindBy(name="search")
	private WebElement searchNowBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateVedorsImg() {
		return createVedorsImg;
	}

	public WebElement getSearchBoxEdit() {
		return searchBoxEdit;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
}
