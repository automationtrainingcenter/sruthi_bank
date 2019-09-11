package utitlities;

import java.io.File;
import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

/*
 * this class provide several methods to read the data from excel files using 
 * jxl jar file. This jxl jar file can only read data from .xls documents
 */
public class ExcelHelper {
	Workbook book;
	Sheet sheet;

	// open excel to read data
	public void openExcel(String folderName, String fileName, String sheetName) {
		try {
			String filePath = System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
			FileInputStream fis = new FileInputStream(filePath);
			book = Workbook.getWorkbook(fis);
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// get number of rows
	public int getRowCount() {
		return sheet.getRows();
	}

	// get number of columns
	public int getColumnCount() {
		return sheet.getColumns();
	}

	// read data from a cell
	public String getCellData(int rnum, int cnum) {
		return sheet.getCell(cnum, rnum).getContents();
	}

	// close the excel
	public void closeExcel() {
		try {
			book.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String[][] getExcelData(String folderName, String fileName, String sheetName) {
		openExcel(folderName, fileName, sheetName);
		int nor = getRowCount();
		int noc = getColumnCount();
		String[][] data = new String[nor-1][noc];
		for (int i = 1; i < nor; i++) {
			for (int c = 0; c < noc; c++) {
				data[i-1][c]= getCellData(i, c);
			}
		}
		closeExcel();
		return data;
	}
	
//	public static void main(String[] args) {
//		ExcelHelper excel = new ExcelHelper();
//		String[][] excelData = excel.getExcelData("", "testdata.xls", "Sheet1");
//		for(String[] row : excelData) {
//			for(String cell : row) {
//				System.out.print(cell+"\t");
//			}
//			System.out.println();
//		}
//	}
}
