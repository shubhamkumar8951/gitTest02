package testGitUpload04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {
	
	public String getData(String sheetName, String testCaseName, String columnName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/Test.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row headerRow = sheet.getRow(0);
		int totalRowNum = sheet.getLastRowNum();
		String valCell = null;

		for (int i = 1; i <= totalRowNum; i++) {
			Row elementRow = sheet.getRow(i);
			HashMap<String, String> exceldata = new HashMap<String, String>();

			for (int j = 0; j < elementRow.getPhysicalNumberOfCells(); j++) {
				Cell cellVal = elementRow.getCell(j);
				if (cellVal.getStringCellValue().equalsIgnoreCase(testCaseName)) {
					for (int k = 1; k < elementRow.getPhysicalNumberOfCells(); k++) {
						Cell currentCell = elementRow.getCell(k);
						if (columnName.equalsIgnoreCase(headerRow.getCell(k).getStringCellValue())) {
							exceldata.put(columnName, currentCell.getStringCellValue());
						}
						if (exceldata.containsKey(columnName)) {
							valCell = exceldata.get(columnName);
						}
					}
				} else {
					break;
				}
			}
		}

		return valCell;

	}
	
	
	
	public String putData(String sheetName, String testCaseName, String columnName, String val) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/Test.xlsx");
		FileOutputStream out;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row headerRow = sheet.getRow(0);
		int totalRowNum = sheet.getLastRowNum();
		String valCell = null;

		
		for (int i = 1; i <= totalRowNum; i++) {
			Row elementRow = sheet.getRow(i);
//			HashMap<String, String> exceldata = new HashMap<String, String>();

			for (int j = 0; j < elementRow.getPhysicalNumberOfCells(); j++) {
				Cell cellVal = elementRow.getCell(j);
				if (cellVal.getStringCellValue().equalsIgnoreCase(testCaseName)) {
					for (int k = 1; k < elementRow.getPhysicalNumberOfCells(); k++) {
						Cell currentCell = elementRow.getCell(k);
						if (columnName.equalsIgnoreCase(headerRow.getCell(k).getStringCellValue())) {
							//exceldata.put(columnName, currentCell.getStringCellValue());
							currentCell.setCellValue(val);
							out = new FileOutputStream(new File(System.getProperty("user.dir") + "/src/test/resources/Test.xlsx"));
							workbook.write(out);
							out.close();
							
						}
						
					}
				} else {
					break;
				}
			}
		}
		

		return valCell;

	}
	
	
}
