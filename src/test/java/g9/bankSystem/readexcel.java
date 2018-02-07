package g9.bankSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel {
	XSSFWorkbook excelWorkbook;
	XSSFSheet excelSheet;
	XSSFCell excelCell;
	XSSFRow excelRow;
	String cellData;

	static String dataFile = "./datafiles/testdata.xlsx";

	public static void main(String[] args) throws IOException {
		readexcel excelUtils = new readexcel();
		excelUtils.readxls(dataFile);
	}

	public void readExcel(String dataFile) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(dataFile);

		// Getting the workbook instance for xlsx file
		excelWorkbook = new XSSFWorkbook(fileInputStream);

		// getting the first sheet from the workbook using sheet name.
		excelSheet = excelWorkbook.getSheet("login");
		// Iterating all the rows in the sheet
		Iterator<Row> rows = excelSheet.rowIterator();

		while (rows.hasNext()) {
			excelRow = (XSSFRow) rows.next();
			// Iterating all the cells of the current row
			Iterator<Cell> cells = excelRow.cellIterator();

			while (cells.hasNext()) {
				excelCell = (XSSFCell) cells.next();

				if (excelCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
					cellData = "Blank";
					System.out.print(cellData);
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
					cellData = "Error";
					System.out.print(cellData);
				}

			}
			System.out.print("\n");

		}
	}

	public void readxls(String dataFile) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(dataFile);

		// Getting the workbook instance for xlsx file
		excelWorkbook = new XSSFWorkbook(fileInputStream);

		// getting the first sheet from the workbook using sheet name.
		excelSheet = excelWorkbook.getSheet("login");

		// getting total number of rows
		int rowcount = excelSheet.getLastRowNum();

		// System.out.println(rowcount);
		// Iterating all the rows in the sheet
		Iterator<Row> rows = excelSheet.rowIterator();

		while (rows.hasNext()) {
			excelRow = (XSSFRow) rows.next();
			// Iterating all the cells of the current row
			Iterator<Cell> cells = excelRow.cellIterator();

			while (cells.hasNext()) {
				excelCell = (XSSFCell) cells.next();

				if (excelCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
					cellData = "Blank";
					System.out.print(cellData);
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
					cellData = excelCell.getStringCellValue();
					System.out.print(cellData + " ");
				} else if (excelCell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
					cellData = "Error";
					System.out.print(cellData);
				}

			}
			System.out.print("\n");

		}
	}

}
