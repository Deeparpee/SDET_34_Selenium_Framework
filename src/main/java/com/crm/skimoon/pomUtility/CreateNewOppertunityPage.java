package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class CreateNewOppertunityPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewOppertunityPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement OppertunityNameEdit;
	
	@FindBy(xpath="//input[@id=\"related_to_display\"]/following-sibling::img")
	private WebElement relatedToImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement relatedToOrganizationLookUp;
	
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement relatedToDropdown;
	
	public WebElement getRelatedToDropdown() {
		return relatedToDropdown;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getOppertunityNameEdit() {
		return OppertunityNameEdit;
	}


	public WebElement getRelatedToImg() {
		return relatedToImg;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement getRelatedToOrganizationLookUp() {
		return relatedToOrganizationLookUp;
	}
	
	
	public void opportunitynameAndSelectContact(String opportunityname)
	{
		OppertunityNameEdit.sendKeys(opportunityname);
		selectByValue(relatedToDropdown, "Contacts");
		relatedToOrganizationLookUp.click();
	}

}
