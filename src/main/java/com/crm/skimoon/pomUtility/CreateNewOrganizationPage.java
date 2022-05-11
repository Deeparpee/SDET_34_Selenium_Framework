package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "accountname")
    private WebElement orgNameEdit;
	
	@FindBy(name= "industry")
    private WebElement industryDropDown;
	
	@FindBy(xpath= "//input[@value='  Save  ']")
    private WebElement savebtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}
	
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void CreateNewOrg(String orgname)
	{
		orgNameEdit.sendKeys(orgname);
		savebtn.click();
	}
	public void CreateNewOrgWithIndustryType(String orgname,String IndustryType)
	{
		orgNameEdit.sendKeys(orgname);
		selectByVisibleText(industryDropDown, IndustryType);
		savebtn.click();
	}

}
