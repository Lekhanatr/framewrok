package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This class consists of generic methods related to files.
 * @author swaroop
 */
public class FileUtility {
	/**
	 * This method will read the data from property file and return the value to the caller
	 * @param key
	 * @return value
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * This method will read the data from Excel file and return the value to the caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return cellValue
	 * @throws IOException
	 */
	public String  readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String cellValue = book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return cellValue;
		
		
	}

}
