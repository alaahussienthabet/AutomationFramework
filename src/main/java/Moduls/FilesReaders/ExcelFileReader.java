package Moduls.FilesReaders;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  how to read test data from excel file
 */
public class ExcelFileReader {
	public static String [][] excelReader(String filename) {
		String[][] data = null;
		XSSFRow row;
	    XSSFCell cell;
		
	    
	    
	   
		
		 try {
				FileInputStream xlfile = new FileInputStream(filename);
				XSSFWorkbook exlreader = new XSSFWorkbook(xlfile);
				for(int i = 0 ; i <	exlreader.getNumberOfSheets() ;i++ ) {
					
					XSSFSheet sheet = exlreader.getSheetAt(i);
					int rows = sheet.getPhysicalNumberOfRows();
					int cells = sheet.getRow(i).getPhysicalNumberOfCells(); 
					data = new String[rows][cells];
					
					for(int j = 0 ; j < rows ; j++ ) {
						
				
						row = sheet.getRow(j);
						 if (row != null) {
						
						for(int y = 0 ; y < cells ; y++) {
							
							cell = row.getCell(y);
							switch(cell.getCellType()) {
							
							case XSSFCell.CELL_TYPE_STRING :
								data[j][y] = cell.getStringCellValue();
								break;
							case XSSFCell.CELL_TYPE_NUMERIC :
								data[j][y] = "" + cell.getNumericCellValue();
								break; 
							}
		 }
						 }}}}
			
		 catch (IOException e) { 
				e.printStackTrace();


				}
		
		return data;
	}}


