package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
 public static WebDriver driver;
//1
  public void getDriver() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
}
  //2
public void lanuchUrl(String url) {
	driver.get(url);
}
//3
public void enterText(WebElement element, String value) {
	element.sendKeys(value);
}
//4
public void buttonClick(WebElement element) {
	element.click();
}
//5
public void dragAndDrop(WebElement source, WebElement target) {
	Actions ac = new Actions(driver);
	ac.dragAndDrop(source, target).perform();	
}
//6
public void getText(WebElement element,String value ) {
	element.getText();
}
//7
public void getAttribute(WebElement element,String value) {
	element.getAttribute(value);
}
//8
public void moveToElement(WebElement target) {
Actions ac = new Actions(driver);
ac.moveToElement(target).perform();
}
//9
public void rightClick(WebElement target) {
	Actions ac = new Actions(driver);
	ac.contextClick(target).perform();

}
//10
public void doubleClick(WebElement target) {
	Actions ac = new Actions(driver);
	ac.doubleClick(target).perform();
}
//11
public void upperCase (WebElement target,String value ) {
	Actions ac = new Actions(driver);
	ac.keyDown(target, Keys.SHIFT).sendKeys(target, value).keyUp(target, Keys.SHIFT);
}
//12
public void keyDown() {
	Actions ac = new Actions(driver);
	ac.keyDown(Keys.DOWN);
}
//13
public void keyup() {
	Actions ac = new Actions(driver);
	ac.keyUp(Keys.UP);
}
//14
public String getExcelData(String pathname, String SheetName, int rowNo,int cellNo) throws IOException  {
File file = new File(pathname);
FileInputStream fileInputStream = new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(fileInputStream);
Sheet sheet = workbook.getSheet(SheetName);
Row row = sheet.getRow(rowNo);
Cell cell = row.getCell(cellNo);
int cellType = cell.getCellType();
String value="    ";
if (cellType==1){
 value = cell.getStringCellValue();	
}
else if (DateUtil.isCellDateFormatted(cell)){
	Date dateCellValue = cell.getDateCellValue();
	SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-YYYY");
	value =dateFormat.format(dateCellValue);
	
}
else {
	double numericCellValue = cell.getNumericCellValue();
	long l= (long) numericCellValue;
	value = String.valueOf(l);
}
return value;
}
//15
public void screenShot(String Data) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File scrfile = ts.getScreenshotAs(OutputType.FILE);
	File destfile = new File(System.getProperty("User.dir")+"\\target"+ Data +".png");
	FileUtils.copyFile(scrfile, destfile);
	
	

}
}
