package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	public static void brwlaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}
	
	public WebElement locatorsxpath(String xpathvalue) {
		WebElement xpath = driver.findElement(By.xpath(xpathvalue));
		return xpath;
	}
	public void enterText(WebElement element,String text) {
	element.sendKeys(text);
	}
	public String excelread(int rowvalue, int cellvalue) throws IOException {
		File f = new File("C:\\Selenium\\Book2.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Sheet2");
		Row row = sheet.getRow(rowvalue);
		Cell cell = row.getCell(cellvalue);
		int cellType = cell.getCellType();
		if(cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		}
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("DD/MM/YYYY");
			String format = s.format(dateCellValue);
			return format;
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long)numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}
	}
		public void Selects(WebElement wref,String select,String text) {
			
			Select s = new Select(wref);
			if(select.equals("value")) {
			s.selectByValue(text);
			}
			else {
				s.selectByVisibleText(text);
			}
				}
     public void waits() {
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 
     }
     public void excelWrite(String value) throws IOException {
		File f = new File("C:\\Selenium\\Book3.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet("Sheet1");
		Row row = createSheet.getRow(0);
		Cell createCell = row.createCell(0);
		createCell.setCellValue(value);
		FileOutputStream stream = new FileOutputStream(f);
		w.write(stream);
		

	}
		
		
		
		
}
