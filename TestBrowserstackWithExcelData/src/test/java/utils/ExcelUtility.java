package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtility(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRowCount() {
		int rowNumber = 0;
		try {
			rowNumber = sheet.getPhysicalNumberOfRows();
			System.out.println("Row number is: " + rowNumber);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowNumber;
	}
	
	public int getColCount() {
		int colNumber = 0;
		try {
			colNumber = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Column number is: " + colNumber);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colNumber;
	}
	
	public String getStringCellData(int rowNo, int ColNo) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNo).getCell(ColNo).getStringCellValue();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
	public double getNumberCellData(int rowNo, int ColNo) {
		double cellData = 0.0;
		try {
			cellData = sheet.getRow(rowNo).getCell(ColNo).getNumericCellValue();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
}
