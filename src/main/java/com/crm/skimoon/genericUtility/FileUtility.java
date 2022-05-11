package com.crm.skimoon.genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * this class contains file format we used to read the common data from property file 
 * @author Dell
 *
 */
public class FileUtility 
{
	public String getKeyValueFromProperty(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.PROPERTY_FILEPATH);
		Properties pobj=new Properties();
		           pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
