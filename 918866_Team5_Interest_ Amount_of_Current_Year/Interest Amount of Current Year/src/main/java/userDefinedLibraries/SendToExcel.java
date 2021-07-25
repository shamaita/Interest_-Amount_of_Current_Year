package userDefinedLibraries;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class SendToExcel extends Utilities{

	// Creating WorkBook
	static XSSFWorkbook workbook = new XSSFWorkbook();

	/*
	 * Send Data to Excel
	 */
	public static void sendData(List<String> data, String sheetName, String princ,String interest)  {
		
		XSSFSheet sheet;
		// Creating Sheet
		if(workbook.getSheetIndex(sheetName)==-1)
			sheet = workbook.createSheet(sheetName);
		else
			sheet=workbook.getSheet(sheetName);
		
		sheet.setColumnWidth(0, 10000);
		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue(princ);
		
		
		sheet.setColumnWidth(1, 10000);
		Cell cell2 = row1.createCell(1);
		cell2.setCellValue(interest);
		
        int cellno = 0;
        Row row = sheet.createRow(1);
		for (String value : data) 
		{
			row = sheet.getRow(1);
			Cell cell = row.createCell(cellno);
			cell.setCellValue(value);
			cellno++;
		}
		FileOutputStream writefile;
		try {

			// Giving file path and name
			if(browser.equalsIgnoreCase("firefox"))
			{
				writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\firefoxOutput.xlsx");
				workbook.write(writefile);
			}
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\chromeOutput.xlsx");
				workbook.write(writefile);
			}
			
			if(browser.equalsIgnoreCase("edge"))
			{
				writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\edgeOutput.xlsx");
				workbook.write(writefile);
			}
			
			// If file created successfully, prompting the message in the console
			System.out.println("Car Loan File created successfully");
			System.out.println("************************");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * Send Data to Excel
	 */
	public static void sendData1(WebElement yeardata,int m,int i, String sheetName, String year,String princ,String interest, String pay,String bal,String loan) throws IOException 
	{
		XSSFSheet sheet1;
		if(workbook.getSheetIndex(sheetName)==-1)
		{
		   sheet1 = workbook.createSheet(sheetName);	
		   sheet1.setColumnWidth(0, 6000);
		   Row row1 = sheet1.createRow(0);
		   Cell cell1 = row1.createCell(0);
		   cell1.setCellValue(year);
		
		   sheet1.setColumnWidth(1, 6000);
		   Cell cell2 = row1.createCell(1);
		   cell2.setCellValue(princ);
		
		   sheet1.setColumnWidth(2, 6000);
		   Cell cell3 = row1.createCell(2);
		   cell3.setCellValue(interest);
		
		   sheet1.setColumnWidth(3, 6000);
		   Cell cell4 = row1.createCell(3);
		   cell4.setCellValue(pay);
		
		   sheet1.setColumnWidth(4, 6000);
		   Cell cell5 = row1.createCell(4);
		   cell5.setCellValue(bal);
		
		   sheet1.setColumnWidth(5, 6000);
		   Cell cell6 = row1.createCell(5);
		   cell6.setCellValue(loan);
		}
		
		else
		{
			sheet1=workbook.getSheet(sheetName);
		}
		                                                          
	        int cellno = i-1;
		    int j=m/2;
			Row row2 = sheet1.getRow(j);
			
			if (row2 == null)
			{
				row2 = sheet1.createRow(j);
			}
			
			Cell cell = row2.createCell(cellno);
			String data=yeardata.getText();
				cell.setCellValue(data);
				
				FileOutputStream writefile;
		    try {

			// Giving file path and name
			if(browser.equalsIgnoreCase("firefox"))
			{
				writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\firefoxOutput.xlsx");
				workbook.write(writefile);
			}
			
			if(browser.equalsIgnoreCase("chrome"))
			{
					writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\chromeOutput.xlsx");
					workbook.write(writefile);
			}
			
			if(browser.equalsIgnoreCase("edge"))
			{
					writefile = new FileOutputStream(System.getProperty("user.dir") + "\\Output\\edgeOutput.xlsx");
					workbook.write(writefile);
			}
			
			// If file created successfully, prompting the message in the console
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
		

		
		
		
		
