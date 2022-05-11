package com.crm.skimoon.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility
{
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchFieldEdit;
	
	@FindBy(name="search")
	private WebElement searchbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSearchFieldEdit() {
		return searchFieldEdit;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}
	
/*here i am not going to create the business library because here only one 
 * action is there so,we can directly perform action through getters so,
 * need not create the methods.
 */
	public void SearchAndSelectOrganization(String orgname) 
	{
		switchToWindow(driver, "module=Accounts&action");
		searchFieldEdit.sendKeys(orgname);
		searchbtn.click();
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
		switchToWindow(driver, "Potentials&action=EditView");
		savebtn.click();
	}
	
	
	
}
