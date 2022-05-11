package com.crm.OrganizationTest;

import org.testng.annotations.Test;

public class OrganizationTest 
{
	@Test(groups="smokeTest")
	public void createOrg()
	{
		System.out.println("execute createOrg");
		
		System.out.println("********url from cmd line*********"+System.getProperty("url"));
		System.out.println("********browser from cmd line*********"+System.getProperty("browser"));
	}

	@Test(groups="regressionTest")
	public void modifyOrg()
	{
		System.out.println("execute modifyOrg");
	}

	@Test(groups="regressionTest")
	public void deleteOrg()
	{
		System.out.println("execute deleteOrg");
	}

}
