package com.crm.skimoon.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignNameEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	@FindBy(xpath="//input[@name=\"product_name\"]/following-sibling::img")
	private WebElement productLookUpimp;
		
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampaignNameEdit() {
		return campaignNameEdit;
	}
    
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getProductLookUpimp() {
		return productLookUpimp;
	}
	/**
	 * create campaign with mandatory field
	 */
	public void createCapaigm(String campaignname)
	{	
		campaignNameEdit.sendKeys(campaignname);
		savebtn.click();
	}
    /**
     * create campaign with product
     * @param campaignname
     * @param productname
     */
	public void createCapaigmWithProduct(String campaignname,String productname)
	{	
		campaignNameEdit.sendKeys(campaignname);
		productLookUpimp.click();
		switchToWindow(driver,"Products&action=Popup");
		ProductsPage pp=new ProductsPage(driver);
		pp.getSearchBoxEdit().sendKeys(productname);
		pp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[.='"+productname+"']")).click();
		switchToWindow(driver, "Campaigns&action=EditView");
		savebtn.click();
	}

}
