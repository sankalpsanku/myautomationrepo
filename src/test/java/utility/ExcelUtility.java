package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
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
	public static String[][] getExcelTable()
	{
		int numOfRows = sheet.getPhysicalNumberOfRows();
		int numOfCols = 2;
		
		String[][] excelData  = new String[numOfRows][numOfCols];
		
		for(int i=0; i<numOfRows; i++)
		{
			for(int j=0; j<numOfCols;j++)
			{
				excelData[i][j] = getCellData(i,j);
			}
		}
		return excelData;
	}
	public static void setExcelData(int rownum, int colnum, String data) throws Exception
	{
		row = sheet.getRow(rownum);
		cell= row.getCell(colnum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		
		if(cell==null)
		{
			cell=row.createCell(colnum);
			cell.setCellValue(data);
		}
		else 
		{
			cell.setCellValue(data);
		}
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\A06438_P5.Training\\Desktop\\santest\\Sheet1.xlsx");
		
		wBook.write(fos);
		fos.flush();
		fos.close();
	}
}
