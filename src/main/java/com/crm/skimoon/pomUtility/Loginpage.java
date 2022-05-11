package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.FileUtility;

public class Loginpage //Rule-1:Create a separate java class for each and every page in an application
{	
	WebDriver driver;
	/*Rule-03: Create the constructor to initialize the all web elements while creation of an object*/
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * Rule-02:Identify all the elements present in the current dom //and store it
	 * in the corresponding class
	 */	
	@FindBy(name= "user_name")
    WebElement userNameEdit;
		
	@FindBy(name= "user_password")
	private WebElement passwordEdit;
		
	@FindAll({@FindBy(id= "submitButton"), @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	
	/*Rule-04:Declare all the elements as private & provide getters methods*/
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbtn() {
		return loginBtn;
	}
	/*Rule-05:(utilization)use the getters and business libraries*/
	/**
	 * login to appn with parameters
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	public void loginToApp(String username, String password) throws Throwable
	{  FileUtility flib = new FileUtility();
	   flib.getKeyValueFromProperty("url");
	   flib.getKeyValueFromProperty("username");
	   flib.getKeyValueFromProperty("password");
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
	
	/**
	 * login to appn without parameters
	 * @throws Throwable
	 */
	
	public void loginToApp() throws Throwable
	{  FileUtility flib = new FileUtility();
	   String url = flib.getKeyValueFromProperty("url");
	   String username = flib.getKeyValueFromProperty("username");
	   String password = flib.getKeyValueFromProperty("password");
	   driver.get(url);
	   userNameEdit.sendKeys(username);
	   passwordEdit.sendKeys(password);
	   loginBtn.click();
	}
	
}
