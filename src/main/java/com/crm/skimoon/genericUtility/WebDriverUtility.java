package com.crm.skimoon.genericUtility;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

/**
 * * This class contains webDriver specific generic methods
 * @author Dell
 *
 */
public class WebDriverUtility 
{
	SoftAssert s=new SoftAssert();
	/**
	 * this method wait for 20 seconds for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
	}
	/**
	 * This method is wait for the element to be visible
	 * @param driver
	 * @param Element
	 */
	public void waitUntilElementLoad(WebDriver driver,WebElement Element )
	{
		WebDriverWait wait=new WebDriverWait(driver,IConstants.EXPLICITLY_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	/**
	 * This method is wait for the url to be visible
	 * @param driver
	 * @param partialUrl
	 */
	public void waitUntilUrlVisible(WebDriver driver ,String partialUrl)
	{
		WebDriverWait wait=new WebDriverWait(driver,IConstants.EXPLICITLY_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	/**
	 * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAcceptable Exception
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }	
	       }


}
	  /**
	    * this methods enables user to handle dropdown using value
	    * @param element
	    * @param option
	    */ 
	       
	   	   public void selectByValue(WebElement element, String value)
	   {
		   Select select=new Select(element);
		   select.selectByValue(value);
		   
	   }	
	   
	   /**
	    * this methods enables user to handle dropdown using index
	    * @param element
	    * @param index
	    */
	      
	   public void selectByIndex(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }
	   /**
	    * this methods enables user to handle dropdown using visible text
	    * @param element
	    * @param index
	    */
	   public void selectByVisibleText(WebElement element, String text)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(text);   
	   }
	   
	   
	   /**
	    * This method will perform mouse over action
	    * @param driver
	    * @param element
	    */
	   
	   public void mouseOverToElement(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	   
	   /**
	    * This method performs right click operation 
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   
	   /**
	    * This method helps to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
	   }
	   /**
	    * Accept alert 
	    * @param driver
	    */
	   
	   public void acceptAlertAndVerify(WebDriver driver, String confirmationmsg )
	   {
		   Alert a = driver.switchTo().alert();
		   String confirmationactualmsg = a.getText();
		   a.accept();
		   
		   boolean actualconfirmmsg = confirmationactualmsg.contains(confirmationmsg);
		   s.assertTrue(actualconfirmmsg);
		   s.assertAll();
	   }
	   
	   /**
	    * Cancel Alert
	    * @param driver
	    */
	   public void cancelAlertAndDismiss(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
		   
	   }
	   /**
	    * This method used for scrolling action in a webpage
	    * @param driver
	    * @param element
	    */
	   public void scrollToWebElement(WebDriver driver, WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		  int y= element.getLocation().getY();
		   js.executeScript("window.scrollBy(0,"+y+")", element);
	   }
	   
	   
	    public void switchFrame(WebDriver driver,int index) {
	    	driver.switchTo().frame(index);
	    }   
	    
	    public void switchFrame(WebDriver driver,WebElement element) {
	    	driver.switchTo().frame(element);
	    } 
		
	    public void switchFrame(WebDriver driver,String idOrName) {
	    	driver.switchTo().frame(idOrName);
	    } 

	    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
			Date d=new Date();
			String d1=d.toString();
			String d2=d1.replace(":", "-");
			TakesScreenshot ts = (TakesScreenshot) driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File("./photos/"+d2+screenshotName+".jpeg");
	    	Files.copy(src, dest);
	    }
	    
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 


}
