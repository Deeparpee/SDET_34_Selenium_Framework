package com.crm.skimoon.genericUtility;
/**
 * it is a interface and it consists of all the common data which can be used across the framework
 * @author Dell
 *
 */
public interface IConstants 
{
	String EXCEL_PATH="./data/data.xlsx";
	String PROPERTY_FILEPATH="./data/commondata.properties";
	String JDBC_URL_String="jdbc:mysql://localhost:3306/students";
	String JDBC_USERNAME="root";
	String JDBC_PASSWORD="root";
	int IMPLICITLY_WAIT_TIMEOUT=20;
	int EXPLICITLY_WAIT_TIMEOUT=20;
}
