package org.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Studentdet2 {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Cynthia\\eclipse-workspace\\New\\Excelread\\FramesData.xlsx");
		FileInputStream Stream= new FileInputStream(file);
		Workbook a= new XSSFWorkbook(Stream);
		Sheet sheet = a.getSheet("Sheet2");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int cellType = cell.getCellType();
				if (cellType==1) {
					String v = cell.getStringCellValue();
					System.out.println(v);
				}
				else  if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy");
					String f = date.format(d);
					System.out.println(f);				
				}else {
					double pnt = cell.getNumericCellValue();
					long l= (long)pnt;
					System.out.println(l);
				}
	}
			}
		}
	}

