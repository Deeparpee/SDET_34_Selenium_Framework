package com.crm.skimoon.pomUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingContactInformation 
{
	WebDriver driver;
	public EditingContactInformation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='lastname']")
    WebElement editcontactlastname;
	
	@FindBy(xpath= "//input[@value='  Save  ']")
    WebElement savebtn;
	
	@FindBy(className="dvHeaderText")
	private WebElement conctactInfotitle;
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEditcontactlastname() {
		return editcontactlastname;
	}
	
	public WebElement getConctactInfotitle() {
		return conctactInfotitle;
	}

	public void Editcontactlastname(String replace_lastname) 
	{
		editcontactlastname.sendKeys(Keys.CONTROL+"a");
		editcontactlastname.sendKeys(replace_lastname);
		savebtn.click();
	}
	

}
