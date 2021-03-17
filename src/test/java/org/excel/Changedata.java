package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Changedata {
public static void main(String[] args) throws FileNotFoundException,IOException{
	File file= new File("C:\\Users\\Cynthia\\eclipse-workspace\\New\\Excelread\\FramesData.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook w = new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet2");
	Row r = s.getRow(1);
	Cell c = r.getCell(1);
	String s1 = c.getStringCellValue();
	System.out.println(s1);
	if (s1.equalsIgnoreCase("archana")) {
		c.setCellValue("Amala");		
	}
	FileOutputStream stream2= new FileOutputStream (file);
	w.write(stream2);
	System.out.println("Done");
}
}
