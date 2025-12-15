package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.OrangeHRM.genericScripts.I_Appilcaton_Constant;

public class ReadExcel
{	
	static FileInputStream fis;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	static int lastcell;
	
	
		public static int LastRowNumber(String Excelpath,String sheetname) throws Exception
		{
			fis = new FileInputStream(Excelpath);
			 book = new XSSFWorkbook(fis);
			 sheet = book.getSheet(sheetname);
			int lastrownum =sheet.getLastRowNum();
			return lastrownum;	
			
		}
		
	
		public static int LastCellNumber(String Excelpath, String sheetname) throws Exception
		{
			fis = new FileInputStream(Excelpath);
			 book = new XSSFWorkbook(fis);
			 sheet = book.getSheet(sheetname);
			for(int r =0; r<=LastRowNumber( Excelpath, sheetname);r++)
			{
				XSSFRow Row= sheet.getRow(r);
				for(int c=0;c<Row.getLastCellNum();c++)
				{
			lastcell =	Row.getLastCellNum();
				}
			}
			return lastcell;
		}
		
		public static XSSFSheet AccessSheet(String Excelpath,String sheetname) throws Exception
		{
			 fis = new FileInputStream(Excelpath);
			 book = new XSSFWorkbook(fis);
			 sheet = book.getSheet(sheetname);
			return sheet;
		}
		
		
	
		public static XSSFRow AccessRow(String Excelpath,String sheetname,int row) throws Exception
		{
			 fis = new FileInputStream(Excelpath);
			 book = new XSSFWorkbook(fis);
			 sheet = book.getSheet(sheetname);
			XSSFRow Row= sheet.getRow(row);
			return Row;
		}
		
		public static XSSFCell AccessCell(String Excelpath,String sheetname,int row,int cell) throws Exception
		{
			 fis = new FileInputStream(Excelpath);
			 book = new XSSFWorkbook(fis);
			sheet = book.getSheet(sheetname);
			XSSFRow Row = sheet.getRow(row);
			XSSFCell Cell = Row .getCell(cell);
			return Cell;
		}
		
		
		public static String AccessCellValue(String Excelpath,String sheetname,int row, int cell) throws Exception
		{
			fis = new FileInputStream(Excelpath);
			book = new XSSFWorkbook(fis);
			sheet = AccessSheet(Excelpath,sheetname);
			XSSFRow Row = AccessRow(Excelpath,sheetname,row);
			XSSFCell Cell = AccessCell(Excelpath,sheetname,row,cell);
			String value = Cell.getStringCellValue();
			return value;
			
			
		}
		
		
		
		
}
