package mainFunctionalities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import userDefinedLibraries.*;

public class HomeLoanFunctionalities extends Utilities 
{
	public static String[] data;
	public static WebElement ele1;
	
	/*
	 * Scrolling up to view the main menu
	 */
	public void scrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath(config.getProperty("homeLoan")));
		js.executeScript("arguments[0].scrollIntoView();", element);
		waitElementClickable(config.getProperty("homeLoan"));
	}
	
   

	/*
	 * Entering the Home Loan Amount, Interest Rate and Loan Tenure details by reading from /Input/Input.xlsx file
	 */
    public void inputData(String sheet)  
    {
		WebElement loanAmount, interestRate, loanTenure;
		InputFromExcel in=new InputFromExcel();
		int column = 0;
		int row=1;
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loanamount"))));
		loanAmount = driver.findElement(By.id("loanamount"));
		loanAmount.clear();
		loanAmount.sendKeys(in.readExcelData(row, column++));
		
		interestRate=driver.findElement(By.id("loaninterest"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loaninterest"))));
		interestRate.click();
		interestRate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		interestRate.sendKeys(Keys.DELETE);
		interestRate.sendKeys(in.readExcelData(row, column++));
		
		loanTenure=driver.findElement(By.id("loanterm"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loanterm"))));
		loanTenure.click();
		loanTenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		loanTenure.sendKeys(Keys.DELETE);
		loanTenure.sendKeys(in.readExcelData(row, column++));
		loanTenure.sendKeys(Keys.TAB);
			
	}
	
    /*
	 * Scrolling down to view the details 
	 */
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.id("yearheader"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable((By.id("yearheader"))));
		
	}
	
	/*
	 * Entering the values of principal and interest amount for first month into excel file
	 */
	public void writeYearWiseData()
	{
	  InputFromExcel in=new InputFromExcel();
	  String tenure1=in.readExcelData(1,2);
	  int tenure=Integer.parseInt(tenure1);
	  for(int m=1;m<=(tenure*2);m++)
	  {
	  int n=m*2;;
	  for(int i=1;i<=6;i++)
	   {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(
		(By.xpath("//*[@id='emipaymenttable']/table/tbody/tr["+n+"]/td["+i+"]"))));
		
		ele1=driver.findElement(By.xpath("//*[@id='emipaymenttable']/table/tbody/tr["+n+"]/td["+i+"]"));
		try {
		SendToExcel.sendData1(ele1,n,i, "HomeLoan", "YEAR", "PRINCIPAL AMOUNT","INTEREST AMOUNT","TOTAL PAYMENT","BALANCE","Loan Paid To Date");
		} catch (IOException e) {
			e.printStackTrace();
	
		   }
	    }
		
	  }
		System.out.println("Home Loan File created successfully");
		System.out.println("************************************************************");
	}
	
	
	
	
}
