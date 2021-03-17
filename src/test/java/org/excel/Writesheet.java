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

public class Writesheet {
		public static void main(String[] args) throws FileNotFoundException,IOException {
			File file= new File("C:\\Users\\Cynthia\\eclipse-workspace\\New\\Excelread\\FramesData.xlsx");
			FileInputStream Stream= new FileInputStream(file);
			Workbook b = new XSSFWorkbook(Stream);
			Sheet w = b.createSheet("New");
			Row cr = w.createRow(0);
			Cell data = cr.createCell(1);
			data.setCellValue("Friends List");
			FileOutputStream Streamout = new FileOutputStream(file);
			b.write(Streamout);
		}
		}


