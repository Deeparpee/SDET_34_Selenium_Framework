package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage 
{
	WebDriver driver;
	public CreateNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductNameEdit() {
		return productNameEdit;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public void createNewProduct(String productName)
	{
		productNameEdit.sendKeys(productName);
		savebtn.click();
	}

}
