package com.intetbanking.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream finput;
	public static FileOutputStream fouptut;
	public static XSSFWorkbook workbook;
	public static XSSFSheet xlWorksheet;
	public static XSSFRow xlRow;
	public static XSSFCell xlCell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws IOException {
		
		finput = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(finput);
		xlWorksheet = workbook.getSheet(xlSheet);
		
		int rowcount = xlWorksheet.getLastRowNum();
		
		workbook.close();
		finput.close();
		
		return rowcount;
		
	}

	
	public static int getColumnCount(String xlFile, String xlSheet, int rowNumber) throws IOException{
		
		finput = new FileInputStream(xlFile);
		workbook = new XSSFWorkbook(finput);
		xlWorksheet = workbook.getSheet(xlSheet);
		xlRow = xlWorksheet.getRow(rowNumber);
				
		int columnCount = xlRow.getLastCellNum();

		return columnCount;
	}
	
	public static String getCellData(String xlFile, String xlSheet, int rowNumber, int colNumber) throws IOException {
		
		workbook = new XSSFWorkbook(new FileInputStream(xlFile));
		xlWorksheet = workbook.getSheet(xlSheet);
		xlRow = xlWorksheet.getRow(rowNumber);
		xlCell = xlRow.getCell(colNumber);
		
		String cellData = xlCell.getStringCellValue();
		
		return cellData;
	}
	
}
