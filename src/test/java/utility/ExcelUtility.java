package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFWorkbook wBook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static void setExcelPath(String sheetName, String path) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(path);
		
		wBook = new XSSFWorkbook(fis);
		sheet = wBook.getSheet(sheetName);
		
	}
	public static String getCellData(int rownum, int column)
	{
		String stringCellData;
		row = sheet.getRow(rownum);
		cell = row.getCell(column);
		
		stringCellData = cell.getStringCellValue();
		
		return stringCellData;
	}
}
