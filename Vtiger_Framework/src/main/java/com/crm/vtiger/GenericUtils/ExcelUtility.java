package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Akshata
 *
 */
public class ExcelUtility
{
	/**
	 * This method used to read data from excel by specifing sheetName, row number and cell Number
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.Excel_FilePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
				
		return cell.getStringCellValue();
		
	}
	
	/**
	 * This Method return all the data in the sheet 
	 * We used this becasuse we are using Multiple Data for running same Scripts	 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstant.Excel_FilePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();  // We don't know how many rows are there thats why we use lastrownum()
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		//We don't know what is inside in [lastRow][lastCell] the value that's why we used object
		Object[][] data = new Object[lastRow][lastCell];
		
		for (int i=0 ; i<lastRow; i++) 
		{
			for(int j=0 ; j<lastCell ; j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	/**
	 * This method used to write data inside the excel sheet
	 * @param sheetName
	 * @param rownum
	 * @param column
	 * @param value
	 * @throws Throwable
	 */
	public void writeExcelData(String sheetName, int rownum,int column, String value) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstant.Excel_FilePath);
		Workbook workbook = WorkbookFactory.create(file);
		workbook.createSheet(sheetName).createRow(rownum).createCell(column).setCellValue(value);
		FileOutputStream writeFile = new FileOutputStream(IPathConstant.Excel_FilePath);
		workbook.write(writeFile);
	}
}
