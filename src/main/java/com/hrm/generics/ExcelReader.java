package com.hrm.generics;


import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader 
{
	private static Workbook wb;
	private static Sheet s;
	private static Row r;
	private static Cell c;
	
	public static int getLastRowCount(String Sheetname)
	{
		try {
			
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return wb.getSheet(Sheetname).getLastRowNum();
	}
	
	public static int getLastCellCount(String Sheetname, int rownum)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 return wb.getSheet(Sheetname).getRow(rownum).getLastCellNum();
	}
	
	public static String readExcelFile(String Sheetname, int rownum, int cellnum)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).toString();
	}
	
	public static void setExcelFile(String Sheetname, int rownum, int cellnum, String value)
	{
		try 
		{
			wb=WorkbookFactory.create(new FileInputStream(Autoconstants.excelpath));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).setCellValue(value);
		try 
		{
			wb.write(new FileOutputStream(Autoconstants.excelpath));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
