package com.crm.skimoon.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Dell
 *
 */
public class DatabaseUtility 
{
	static Connection conn;
	static ResultSet result;
	static Driver driver;

	/**
	 * This method is used to connect to the mysql database
	 * @throws Throwable
	 */
	public void getConnectionToDatabase() throws Throwable
	{   		
	    try{
	    	Driver diverref=new Driver();
	    	DriverManager.registerDriver(diverref);
			conn=DriverManager.getConnection(IConstants.JDBC_URL_String,IConstants.JDBC_USERNAME , IConstants.JDBC_PASSWORD);
			System.out.println("Database is connected");
	       }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    	
	}
	/**
	 * This method is used to execute the query and verify the expectedData with the corresponding stringData whatever we fetch the data from the database table 
	 * @param query
	 * @param index
	 * @param data
	 * @return
	 * @throws Throwable
	 */
	public boolean excecuteQueryAndVerify(String query,int column_index, String expectedData) throws Throwable
	{
	    boolean flag=false;
		result= conn.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(column_index).equals(expectedData))
			{
				flag=true;
				break;
		}
	}
		if(flag)
		{
			System.out.println(expectedData+"==>Data is verified in the database table");
		}
		else {
			System.out.println(expectedData+"==>Data is not verified in the database");
		}
		return flag;
	
	
	}
	/**
	 * this method will execute the query and it will return the result in the form of table
	 * @param query
	 * @param index
	 * @throws Throwable
	 */
	public ResultSet executeQueryAndFetch(String query) throws Throwable
	{
		result= conn.createStatement().executeQuery(query);
		return result;
	   
	}
	/**
	 * This method is used to execute to the query and by using this method we can insert the data into the database
	 * @param query
	 * @param index
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable
	{
		int result= conn.createStatement().executeUpdate(query);
		return result;
	   
	}
	/**
	 * this method is used to close the database connection
	 * @throws Throwable
	 */
	public void closeDatabase() throws Throwable
	{ 
		try {
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Database is closed");
		}
	}

}

