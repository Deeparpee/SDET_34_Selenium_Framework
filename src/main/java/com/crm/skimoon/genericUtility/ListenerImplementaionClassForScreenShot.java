package com.crm.skimoon.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementaionClassForScreenShot implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		JavaUtility jlib=new JavaUtility();
		String testName = result.getMethod().getMethodName();
		System.out.println(testName + "    i am listening");
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		File destfile=new File("./screenshot/"+testName+"_"+jlib.getSystemCurrentDate()+".png");
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) 
		{
			System.out.println("handled");
		}
	}

}
