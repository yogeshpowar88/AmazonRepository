package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String FailedTestCasesTakeScreenshot(WebDriver driver,String testID) throws IOException{
		Date date = new Date();
		String dateAndTime = date.toString().replace("Sat Apr 01", "01-05-2023").replace("13:44:05", "01 44 05").replace("IST 2023", "");		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		
		File FailedTestCaseScreenShot = new File("test-output\\FailedTestCasesScreenShot\\"+ testID +".png");
		
		//FileHandler.copy(src, FailedTestCaseScreenShot);
		FileHandler.copy(src,FailedTestCaseScreenShot);
		return testID;
		
		}
	
	public static String GetExcelDada (String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		String path = "src/main/resources/Data/Data.xlsx";

		FileInputStream file = new FileInputStream(path);
		
		try 
		{
			String data =  WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
		}
		catch (ArithmeticException e)
		{
			Cell data1 = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);
			double data2 = data1.getNumericCellValue();
			String data = Double.toString(data2);
			
			//data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		}
		
		return path;
		
		
//		double data = 123.456d;
//		String str = String.valueOf(d);
		
		
		
		
	}
	

}
