package com.crm.skimoon.pomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationslink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitieslink;
	
	@FindBy(linkText="Products")
	private WebElement productslink;
	
	@FindBy(linkText="Documents")
	private WebElement documentslink;
	
	@FindBy(xpath="//a[.='More']")
	private WebElement moredropdown;
	
	@FindBy(linkText= "Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutlink;
	
	@FindBy(linkText= "Purchase Order")
	private WebElement purchaseOrderlink;
	
	@FindBy(linkText= "Vendors")
	private WebElement vendorslink;
		
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getVendorslink() {
		return vendorslink;
	}

	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getOpportunitieslink() {
		return opportunitieslink;
	}

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getDocumentslink() {
		return documentslink;
	}

	public WebElement getMoredropdown() {
		return moredropdown;
	}

	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public WebElement getPurchaseOrderlink() {
		return purchaseOrderlink;
	}

	public void logout()
	{
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseOverToElement(driver, administratorimg);
		wlib.waitUntilElementLoad(driver, signoutlink);
		signoutlink.click();
	}
	
	public void navigateToCampaign()
	{	
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseOverToElement(driver, moredropdown);
		campaignslink.click();	
	}
	public void navigateToPurchaseOrder()
	{	
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseOverToElement(driver, moredropdown);
		purchaseOrderlink.click();	
	}
	public void navigateToVedors()
	{	
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.mouseOverToElement(driver, moredropdown);
		vendorslink.click();	
	}

}
