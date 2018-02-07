package g9.excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtils {

	private static Workbook excelWorkbook;
	private static Sheet excelSheet;
	private static Cell cell;
	private static String cellData;

	public static final String EXCEL_PATH = "./datafiles/testdata.xlsx";

	public static Object[][] getTableArrays(String filepath, String sheetName) throws InvalidFormatException {

		String[][] tabArrayString = null;

		try {

			FileInputStream excelFile = new FileInputStream(filepath);
			excelWorkbook = WorkbookFactory.create(excelFile);
			excelSheet = excelWorkbook.getSheet(sheetName);
			int ci = 0, cj;
			int totalRows = excelSheet.getLastRowNum();
			System.out.println("Total Rows: " + totalRows);
			// int totalRows = getRowCount(sheetName);
			int totalCols = excelSheet.getRow(0).getLastCellNum();
			System.out.println("Total Cols: " + totalCols);
			tabArrayString = new String[totalRows][totalCols];

			for (int i = 1; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = 0; j <= totalCols - 1; j++, cj++) {
					tabArrayString[ci][cj] = getCellData(i, j);
					System.out.println("Row: " + i + " Col:  " + j + "::" + tabArrayString[ci][cj]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (tabArrayString);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = excelSheet.getRow(RowNum).getCell(ColNum);
			if (cell == null) {

				cellData = "";

			} else
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:

					cellData = "";
				case Cell.CELL_TYPE_BOOLEAN:

					cellData = (String.valueOf(cell.getBooleanCellValue()));

				case Cell.CELL_TYPE_NUMERIC:

					cellData = (String.valueOf(cell.getNumericCellValue()));

				case Cell.CELL_TYPE_STRING:

					cellData = (String.valueOf(cell.getStringCellValue()));

				}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}
		return cellData;

	}

	/*
	 * public static void main(String[] args) throws InvalidFormatException {
	 * getTableArrays(excelUtils.FILE_PATH, "Login"); }
	 */
}
