package com.crm.skimoon.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains excel generic methods and it is used to handle the Microsoft excel sheet
 * @author Dell
 *
 */
public class ExcelUtility
{
	/**
	 * this method is used to read the data from excel sheet with below mentioned parameters
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		String data = r.getCell(cellnum).getStringCellValue();
		return data;
		
	}
	/**
	 * this method is used to get the count of last row count on specified sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		int lastrownum = sh.getLastRowNum();
		book.close();
		return lastrownum;
	}
	/**
	 * this method is used to write the data into the excel sheet with below mentioned parameters
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataToExcel(String sheetname,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		Cell c = r.createCell(cellnum);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IConstants.EXCEL_PATH);
		book.write(fos);
		book.close();
	}
    
	//This method is used to create and read data from dataprovider
		/**
		 * This method is used to read data from excel sheet and provide that data to dataprovider
		 * @param sheetName
		 * @return
		 * @throws Throwable
		 */
		public Object[][] readDataForDataProvider(String sheetName) throws Throwable
		{
			//Step 1:
			FileInputStream fis = new FileInputStream(IConstants.EXCEL_PATH);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			System.out.println(lastRow);
			int lastCell = sheet.getRow(0).getLastCellNum();
			Object[][] data = new Object[lastRow][lastCell];
			System.out.println(lastCell);
			for(int i=0;i<lastRow;i++)
			{
				for(int j=0;j<lastCell;j++)
				{
					data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				}
			}
			
			return data;
			
		}

}
