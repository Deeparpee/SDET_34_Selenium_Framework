package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "lastname")
    WebElement contactLastNameEdit;
	
	@FindBy(name= "firstname")
    WebElement contactFirstNameEdit;
	
	@FindBy(xpath= "//input[@value='  Save  ']")
    WebElement savebtn;
	
	@FindBy(xpath= "//input[@value='T']")
    WebElement groupRadiobtn;
	
	@FindBy(xpath= "//select[@name='assigned_group_id']")
    WebElement groupdropdown;
		
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactNameEdit() {
		return contactLastNameEdit;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getContactLastNameEdit() {
		return contactLastNameEdit;
	}

	public WebElement getContactFirstNameEdit() {
		return contactFirstNameEdit;
	}
	
	public WebElement getGroupdropdown() {
		return groupdropdown;
	}
	
	public WebElement getGroupRadiobtn() {
		return groupRadiobtn;
	}

	public void CreateNewContact(String lastname)
	{
		contactLastNameEdit.sendKeys(lastname);
		savebtn.click();
	}
	
	public void CreateNewContactWithoutMandatory(String firstname)
	{
		contactFirstNameEdit.sendKeys(firstname);
		savebtn.click();
	}
	
	public void CreateNewContactWithGroupDropdown(String lastname)
	{
		contactLastNameEdit.sendKeys(lastname);
		groupRadiobtn.click();
		selectByValue(groupdropdown, "4");
		savebtn.click();
	}
	
	
}
