package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	
	@Test
public void WriteExcel() throws IOException {	
	
  FileInputStream fis =new FileInputStream("./src/test/resources/writeexcel.xlsx");	
  XSSFWorkbook workbook = new XSSFWorkbook(fis);
  XSSFSheet sheet = workbook.getSheet("writeexcel");
  XSSFRow Row = sheet.createRow(1);
  XSSFCell cell = Row.createCell(1);
  
  //cell.setCellType(cell.));
  cell.setCellValue("softwareTestingMaterial.com");
  FileOutputStream fos= new FileOutputStream("./src/test/resources/writeexcel.xlsx");
  workbook.write(fos);
  fos.close();
  System.out.println("end of writing data in excel");
  

}
}
