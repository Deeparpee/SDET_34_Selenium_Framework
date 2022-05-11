package com.crm.skimoon.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
    WebElement createContactImg;
	
	@FindBy(xpath="//input[@name='search_text']")
    WebElement ContactSearchField;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
    WebElement ContactSearchNowbutton;
	
	@FindBy(name="search")
    WebElement searchNowbutton;
	
	@FindBy(id="bas_searchfield")
    WebElement searchByLastname;
	
	@FindBy(xpath="//input[@value='Delete']")
    WebElement deletebtn;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
    WebElement editbtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
    
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getContactSearchField() {
		return ContactSearchField;
	}

	public WebElement getContactSearchNowbutton() {
		return ContactSearchNowbutton;
	}

	public WebElement getSearchByLastname() {
		return searchByLastname;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	public WebElement getEditbtn() {
		return editbtn;
	}
	

	public WebElement getSearchNowbutton() {
		return searchNowbutton;
	}

	public void searchLatestContactAndDelete(String lastname)
	{   
		selectByValue(searchByLastname, "lastname");
		ContactSearchField.sendKeys(lastname);
		ContactSearchNowbutton.click();
		driver.findElement(By.xpath("//a[.='"+lastname+"']")).click();
		waitUntilElementLoad(driver, deletebtn);
		deletebtn.click();
	}
	
	public void searchLatestContactAndEdit(String lastname)
	{   
		selectByValue(searchByLastname, "lastname");
		ContactSearchField.sendKeys(lastname);
		ContactSearchNowbutton.click();
		driver.findElement(By.xpath("//a[.='"+lastname+"']")).click();
		editbtn.click();
	}
	
	public void SearchAndSelectContact(String contactlastame) 
	{
		switchToWindow(driver, "Contacts&action=Popup");
		ContactSearchField.sendKeys(contactlastame);
		waitUntilElementLoad(driver, searchNowbutton);
		searchNowbutton.click();
		driver.findElement(By.xpath("//a[.='"+contactlastame+"']")).click();
		waitUntilUrlVisible(driver, "Potentials&action=EditView");
		switchToWindow(driver, "Potentials&action=EditView");
		savebtn.click();
	}

}
