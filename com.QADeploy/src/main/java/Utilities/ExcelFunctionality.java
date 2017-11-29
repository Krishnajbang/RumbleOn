package Utilities;



import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctionality {
		public String TestCaseID;
		public String TestCaseDesc;
		public String Environment;
		public String Browser;
		public String URL;
		public String UserName;
		public String Password;
		public String Title;
		public String strDataItem1;
		public String strDataItem2;
		public String strDataItem3;
		public String strDataItem4;
		
		public void getData(String TestCaseId,String file) throws FileNotFoundException, IOException
		{
			try {
				  // Specify the path of file
				  File src=new File(file);
				 
				   // load file
				   FileInputStream fis=new FileInputStream(src);
				 
				   // Load workbook
				   XSSFWorkbook wb=new XSSFWorkbook(fis);
				   
				   // Load sheet- Here we are loading first sheetonly
				      XSSFSheet sh1= wb.getSheetAt(0);
				 
				  // getRow() specify which row we want to read.
				 
				  // and getCell() specify which column to read.
				  // getStringCellValue() specify that we are reading String data.
				 int rowNo =-1;
				 int lastRowNo = sh1.getLastRowNum();
				 String rowData;
				 for(int i=0; i<lastRowNo;i++)
				 {
					 rowData = sh1.getRow(i).getCell(0).getStringCellValue();
					 if(rowData.equals(TestCaseId))
					 {
						 rowNo =i;
						 break;
					 }
				 }
				 
				 	TestCaseID = sh1.getRow(rowNo).getCell(0).getStringCellValue();
				    TestCaseDesc = sh1.getRow(rowNo).getCell(1).getStringCellValue();
					Environment = sh1.getRow(rowNo).getCell(2).getStringCellValue();
					Browser = sh1.getRow(rowNo).getCell(3).getStringCellValue();
					URL = sh1.getRow(rowNo).getCell(4).getStringCellValue();
					UserName = sh1.getRow(rowNo).getCell(5).getStringCellValue();
					Password = sh1.getRow(rowNo).getCell(6).getStringCellValue();
					Title = sh1.getRow(rowNo).getCell(7).getStringCellValue();
					strDataItem1 = sh1.getRow(rowNo).getCell(8).getStringCellValue();
					strDataItem2 = sh1.getRow(rowNo).getCell(9).getStringCellValue();
					strDataItem3 = sh1.getRow(rowNo).getCell(10).getStringCellValue();
					strDataItem4 = sh1.getRow(rowNo).getCell(11).getStringCellValue();
				 
					
				  } catch (Exception e) {
				 
				   System.out.println(e.getMessage());
				 
				  }
			
			
		}
	
}
