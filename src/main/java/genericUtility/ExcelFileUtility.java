package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
public String readDataFromExcel(String sheetname,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(sheetname);
	Row rw = sh.getRow(rowNo);
	Cell cell = rw.getCell(cellNo);
	String value = cell.getStringCellValue();
	
	
	return value;
	
}
}
