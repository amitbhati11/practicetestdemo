package Exceldemop;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutildemo {
XSSFWorkbook workbook;
XSSFSheet sheet;
	 public Excelutildemo(String xlpath,String Sheetname) throws Exception {
		 
		 workbook=new XSSFWorkbook(xlpath);
		 sheet=workbook.getSheet(Sheetname);
		 
	 }
	 
	
	public int  countrownum() {
	int rowcount=sheet.getPhysicalNumberOfRows();
		
		return rowcount;
	}
	
	public int  countcolnum() {
	int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
	return colcount;
		
	}
	
	public String datacell(int rown, int coln) throws Exception{
		DataFormatter format=new DataFormatter();
	String datavalue=format.formatCellValue(sheet.getRow(rown).getCell(coln));
	return datavalue;
	}
}
