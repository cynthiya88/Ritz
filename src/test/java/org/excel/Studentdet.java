package org.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Studentdet {
	public static void main(String[] args) throws IOException ,FileNotFoundException{
		File file = new File("C:\\Users\\Cynthia\\eclipse-workspace\\New\\Excelread\\FramesData.xlsx");
		FileInputStream Stream= new FileInputStream(file);
		Workbook a= new XSSFWorkbook(Stream);
		Sheet sheet = a.getSheet("Sheet1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				String s = cell.getStringCellValue();
				System.out.println(s);
			}
			
		}

		}
		}


