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
		public String Browser = null;
		public String URL =null;
		public String UserName;
		public String Password;
		public String Title;
		public String strDataItem1;
		public String strDataItem2;
		public String strDataItem3;
		public String strDataItem4;
		public String strDataItem5;
		public String strDataItem6;
        public String strDataItem7;
        public String strDataItem8;
        public String strDataItem9;
        public String strDataItem10;
        public String strDataItem11;
        public String strDataItem12;
        public String strDataItem13;
        public String strDataItem14;
        public String strDataItem15;
        public String strDataItem16;
        public String strDataItem17;
        public String strDataItem18;
        public String strDataItem19;
        public String strDataItem20;
        public String strDataItem21;
        public String strDataItem22;
        public String strDataItem23;
        public String strDataItem24;
        public String strDataItem25;
        public String strDataItem26;
        public String strDataItem27;
        public String strDataItem28;
        public String strDataItem29;
        public String strDataItem30;
		
        

		
		public void getData(String TestCaseId,String file) throws FileNotFoundException, IOException
		{
			File src=new File(file);
			 FileInputStream fis=new FileInputStream(src);
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
			 XSSFSheet sh1= wb.getSheetAt(0);
			 int rowNo =-1;
			 int lastRowNo = sh1.getLastRowNum();
			 String rowData;
			try {
				 
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
					
					System.out.println("TestCaseID: "+TestCaseID);
					System.out.println("TestCaseDesc: "+TestCaseDesc);
					System.out.println("Environment: "+Environment);
					System.out.println("Browser: "+Browser);
					System.out.println("URL: "+URL);
					System.out.println("UserName: "+UserName);
					System.out.println("Password: "+Password);
					System.out.println("Title: "+Title);
					
					strDataItem1 = sh1.getRow(rowNo).getCell(8).getStringCellValue();
					strDataItem2 = sh1.getRow(rowNo).getCell(9).getStringCellValue();
					strDataItem3 = sh1.getRow(rowNo).getCell(10).getStringCellValue();
					strDataItem4 = sh1.getRow(rowNo).getCell(11).getStringCellValue();
					strDataItem5 = sh1.getRow(rowNo).getCell(12).getStringCellValue();
					strDataItem6 = sh1.getRow(rowNo).getCell(13).getStringCellValue();
					strDataItem7 = sh1.getRow(rowNo).getCell(14).getStringCellValue();
					strDataItem8 = sh1.getRow(rowNo).getCell(15).getStringCellValue();
					strDataItem9 = sh1.getRow(rowNo).getCell(16).getStringCellValue();
					strDataItem10= sh1.getRow(rowNo).getCell(17).getStringCellValue();
					strDataItem11= sh1.getRow(rowNo).getCell(18).getStringCellValue();
					strDataItem12= sh1.getRow(rowNo).getCell(19).getStringCellValue();
					strDataItem13= sh1.getRow(rowNo).getCell(20).getStringCellValue();
					strDataItem14= sh1.getRow(rowNo).getCell(21).getStringCellValue();
					strDataItem15= sh1.getRow(rowNo).getCell(22).getStringCellValue();
					strDataItem16= sh1.getRow(rowNo).getCell(23).getStringCellValue();
					strDataItem17= sh1.getRow(rowNo).getCell(24).getStringCellValue();
					strDataItem18= sh1.getRow(rowNo).getCell(25).getStringCellValue();
					strDataItem19= sh1.getRow(rowNo).getCell(26).getStringCellValue();
					strDataItem20= sh1.getRow(rowNo).getCell(27).getStringCellValue();
					strDataItem21= sh1.getRow(rowNo).getCell(28).getStringCellValue();
					strDataItem22= sh1.getRow(rowNo).getCell(29).getStringCellValue();
					strDataItem23= sh1.getRow(rowNo).getCell(30).getStringCellValue();
					strDataItem24= sh1.getRow(rowNo).getCell(31).getStringCellValue();
					strDataItem25= sh1.getRow(rowNo).getCell(32).getStringCellValue();
					strDataItem26= sh1.getRow(rowNo).getCell(33).getStringCellValue();
					strDataItem27= sh1.getRow(rowNo).getCell(34).getStringCellValue();
					strDataItem28= sh1.getRow(rowNo).getCell(35).getStringCellValue();
					strDataItem29= sh1.getRow(rowNo).getCell(36).getStringCellValue();
					strDataItem30= sh1.getRow(rowNo).getCell(37).getStringCellValue();
				  }
			
			catch (NullPointerException e)
			{
				System.out.println(" ");
			}
		}
}
