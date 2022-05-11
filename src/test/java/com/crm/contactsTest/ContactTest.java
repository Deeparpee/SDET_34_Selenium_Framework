package com.crm.contactsTest;

import org.testng.annotations.Test;

public class ContactTest 
{
	@Test(groups="smokeTest")
	public void createContact()
	{
		System.out.println("execute createContact");
		
		System.out.println("********url from cmd line*********"+System.getProperty("url"));
		System.out.println("********browser from cmd line*********"+System.getProperty("browser"));
	}

	@Test(groups="regressionTest")
	public void modifyContact()
	{
		System.out.println("execute modifyContact");
	}

	@Test(groups="regressionTest")
	public void deleteContact()
	{
		System.out.println("execute deleteContact");
	}

}
