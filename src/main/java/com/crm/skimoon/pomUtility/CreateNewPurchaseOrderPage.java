package com.crm.skimoon.pomUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.skimoon.genericUtility.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="subject")
	private WebElement subjectEditBox;
	
	@FindBy(xpath="//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorNameimg;
    
	@FindBy(xpath="//textarea[@class='detailedViewTextBox' and @name='bill_street']")
	private WebElement billingAdressEdit;
	
	@FindBy(xpath="//input[@name='cpy' and @onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingaddressradiobtn;
	
	@FindBy(xpath="//input[@class='small']/following-sibling::img")
	private WebElement itemNameimg;
	
	@FindBy(xpath="//input[@class='detailedViewTextBoxOn']")
	private WebElement quantityEdit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSubjectEditBox() {
		return subjectEditBox;
	}

	public WebElement getVendorNameimg() {
		return vendorNameimg;
	}

	public WebElement getBillingAdressEdit() {
		return billingAdressEdit;
	}

	public WebElement getcopyBillingaddressradiobtn() {
		return copyBillingaddressradiobtn;
	}

	public WebElement getItemNameEdit() {
		return itemNameimg;
	}

	public WebElement getQuantityEdit() {
		return quantityEdit;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createNewPurchaseOrderPage(String subject,String vendorname,String billadress,String productname,String qty)
	{
		subjectEditBox.sendKeys(subject);
		vendorNameimg.click();
		switchToWindow(driver, "Vendors&action=Popup");
		VendorsPage vp=new VendorsPage(driver);
		vp.getSearchBoxEdit().sendKeys(vendorname);
		vp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[.='"+vendorname+"']")).click();
		switchToWindow(driver, "PurchaseOrder&action=EditView");
		waitUntilElementLoad(driver, billingAdressEdit);
		billingAdressEdit.sendKeys(billadress);
		copyBillingaddressradiobtn.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		for(int i=0;i<3;i++)
		{
			js.executeScript("window.scrollBy(0,500)");
		}
		itemNameimg.click();
		switchToWindow(driver, "Products&action=Popup");
		ProductsPage pp=new ProductsPage(driver);
		pp.getSearchBoxEdit().sendKeys(productname);
		vp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[.='"+productname+"']")).click();
		switchToWindow(driver, "PurchaseOrder&action=EditView");
		waitUntilElementLoad(driver, quantityEdit);
		quantityEdit.sendKeys(qty);
		savebtn.click();
	}
	
}
