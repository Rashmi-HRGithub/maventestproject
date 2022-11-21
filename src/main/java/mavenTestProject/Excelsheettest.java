package mavenTestProject;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheettest extends JavaUtility {
	/**
	 * This method are used to read and write data using Excel
	 * @author 
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
	

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	
	{
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\docror.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro=sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
	}
	
	public String writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo,String Date)  throws Throwable
	{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	Row ro=sh.getRow(RowNo);
    Cell cell = ro.createCell(ColumnNo);
    cell.setCellValue(Date);
    FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
     wb.write(fos);	
     return Date;
}
	
	/**This is used to get last row count
	 * @author 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getLastRowNum(String sheetName) throws Throwable{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);	
		int count =sh.getLastRowNum();
		return count;
	}

	
	public Map<String, String> getList(String sheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);	
		int count =sh.getLastRowNum();
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0; i<=count; i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
		String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key,value);
		if(key.equals("docemail"))
		{
		value=value+"_"+getRanDomNumber();
		}  
		
	}
		return map;
	}
	
public class Excelsheettest1 {

	public Object[][] readMultipleData(String sheetName) throws Throwable
	{
		
		FileInputStream fi=new FileInputStream("./src/test/resources/data5row3col.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh =wb.getSheet("DataProvider");
		int lastRow=sh.getLastRowNum();                //// add +1 to avoid exception 
		short lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastRow][lastCell];
		for (int i=0; i<lastRow;i++) {
			
			for(int j=0;j<lastCell;j++) {
			
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			
		}
		
	}
		return obj;
	}
}
}



