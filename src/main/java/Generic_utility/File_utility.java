package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**This consist of generic file
 * @author HP
 */

public class File_utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	/**This will read and return the value
	 * 
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String propertyfile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
		
	}	
		
	/**This method is for get the data from excel and return the value
	 * 
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return value
	 * @throws IOException
	 */
	public String excel(String sheetname, int rowno, int cellno) throws IOException
	{
		FileInputStream xfile = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(xfile);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String value = cell.getStringCellValue();
		return value;
		
		
		
	}
	

}
