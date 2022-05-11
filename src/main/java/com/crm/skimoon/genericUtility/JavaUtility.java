package com.crm.skimoon.genericUtility;

import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific generic methods
 * @author Dell
 *
 */
public class JavaUtility 
{
	/**
	 * it is used to generate the random number
	 * @return
	 */
	public static int getRandomNum()
	{
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		return rannum;
		
	}
	/**
	 * this method is used to get the system current date i.e. yyyy-mm-dd
	 * @return
	 */
	public String getSystemCurrentDate()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		int mm = date.getMonth()+1;
		String dd = dateAndTime.split(" ")[2];
		String dateformat=dd +"-"+mm+"-"+yyyy;
		return dateformat;
	}
	
	public String getSystemCurrentDateAndTime()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		String dateAndTime2 = dateAndTime.replaceAll(":", "-");
		return dateAndTime2;
	}
	

}
