package com.restAssured.com.restAssured.Deepak;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class cf {
	
	public String testcaseName;
	public ExtentReports extent;
	public ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	
	
	
	
	
	public void updateTestLog(String expected, String actual, String STATUS)
	{
		
		extent = getInstance();
		test = extent.createTest("Hi");
		
		
		if(STATUS.toUpperCase().equals("PASS"))
		{
		test.pass("Expected: "+expected+"Actual: "+actual);
		}else if(STATUS.toUpperCase().equals("FAIL"))
		{
			test.fail("Expected: "+expected+"Actual: "+actual);
		}else if(STATUS.toUpperCase().equals("INFO"))
		{
			test.info(expected);
		}
		
		extent.flush();
		
	}
	
	
	
	
	public String getData(String SheetName, String fieldName) throws IOException
	{
		
	
		
		
		String testData = null;
				
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/GlobalProperties.properties"));
		String workbookName = prop.getProperty("WorkbookName");
			
			String excelPath = System.getProperty("user.dir")+"/com.restAssured.Deepak/src/test/java/com/restAssured/com/restAssured/Deepak/"+workbookName;		
			Workbook wb = new XSSFWorkbook(new FileInputStream(excelPath));	
			
			Sheet ws = wb.getSheet(SheetName);
			int maxRow = ws.getLastRowNum();
		
		
			
			//GetRowContaining testcaseName
			
			int currentRowNo=0;
			
		   for(int rowNo=0;rowNo<=maxRow;rowNo++)
		   {
			   
			   
			   Row row= ws.getRow(rowNo);
			   Cell cell = row.getCell(0);
			   String mycellValue = cell.getStringCellValue();
			   
			   if(testcaseName.contains(mycellValue))
					   {
				   
				   
				   currentRowNo=rowNo;
				   break;
				   
					   }
			  
			   
		   }
		
		   //GetColumnn containing required field name
			
		   int currentColumnNo=0;
		   
		   Row topRow = ws.getRow(0);
		   int maxCol=topRow.getLastCellNum();
		   
		   for(int colNo=0;colNo<=maxCol;colNo++)
		   {
			   
			   
			   Row row= ws.getRow(0);
			   Cell cell = row.getCell(colNo);
			   String mycellValue = cell.getStringCellValue();
			   
			   if(mycellValue.equalsIgnoreCase(fieldName))
					   {
				   
				   
				   currentColumnNo=colNo;
				   break;
				   
					   }
			   
		   }
		   
		   
		   
		   //Getting myData value
		   
		   
		   Row row= ws.getRow(currentRowNo);
		   Cell cell = row.getCell(currentColumnNo);
		   testData = cell.getStringCellValue();
		   
		   System.out.println(testData);
		  
			
			
			
		


		
		return testData;
		
		
	
		
		
	}
	
	
	
	
	
	public ExtentReports getInstance()
	{
		
		
		
		
		String fileName = "//Users//deepak//Documents//workspace//ExtentReports//report.html";
	
		if (extent==null)
		{
			
			extent	 = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(fileName);
			htmlReporter.config().setChartVisibilityOnOpen(true);			
		    htmlReporter.config().setDocumentTitle("RestAssured");
		    htmlReporter.config().setReportName("Service Testing for Rest API");
			extent.attachReporter(htmlReporter);

			
			
		}
		
		return extent;
		
		
		
	}
	

}
