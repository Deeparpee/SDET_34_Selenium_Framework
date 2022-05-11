package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class ProductsPage extends WebDriverUtility
{
	WebDriver driver;
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductImg;
	
	@FindBy(name="search_text")
	private WebElement searchBoxEdit;
	
	@FindBy(name="search")
	private WebElement searchNowBtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProductImg() {
		return createProductImg;
	}

	public WebElement getSearchBoxEdit() {
		return searchBoxEdit;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

}
