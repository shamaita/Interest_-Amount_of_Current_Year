package mainFunctionalities;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import userDefinedLibraries.*;

public class CarLoanFunctionalities extends Utilities {
	
	/*
	 * Selection of  Loan Option from the main menu
	 */

	public void selectLoan(String loan)
	{
		waitElementClickable(config.getProperty(loan));
		driver.findElement(By.xpath(config.getProperty(loan))).click();
	}
	
	/*
	 * Entering Car Loan Amount, Interest Rate and Loan Tenure details
	 */
	public void enterDetails(String amount, String ir,String tenure)  
	{
		WebElement loanAmount, interestRate, loanTenure;
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loanamount"))));
		loanAmount = driver.findElement(By.id("loanamount"));
		loanAmount.clear();
		loanAmount.sendKeys(amount);
		
		interestRate=driver.findElement(By.id("loaninterest"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loaninterest"))));
		interestRate.click();
		interestRate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		interestRate.sendKeys(Keys.DELETE);
		interestRate.sendKeys(ir);
		
		loanTenure=driver.findElement(By.id("loanterm"));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("loanterm"))));
		loanTenure.click();
		loanTenure.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		loanTenure.sendKeys(Keys.DELETE);
		loanTenure.sendKeys(tenure);
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
	 * To display the details of principal and interest amount for each month
	 */
	public void selectMonth()
	{
		List<WebElement> test=	driver.findElements(By.xpath(config.getProperty("selectMonth")));
		for(WebElement list:test)
		{
			waitElementClickable(config.getProperty("selectMonth"));
            list.click();
		}
	}
	
	
	/*
	 * Entering the values of principal and interest amount for first month into excel file
	 */
	public void printResult()  
	{
		waitElementClickable(config.getProperty("selectMonth"));
		String principal =driver.findElement(By.xpath(config.getProperty("principalAmount"))).getText();
		String principal1=principal.substring(1, principal.length()); 
	    System.out.println("Principal amount for first month: Rs"+principal1);
		
		String interest = driver.findElement(By.xpath(config.getProperty("interestAmount"))).getText();
		String interest1=interest.substring(1, interest.length());
	    System.out.println("Interest amount for first month: Rs"+interest1);
	   
		List<String> data = new ArrayList<String>();
	    data.add(principal);
		data.add(interest);
		SendToExcel.sendData(data, "CarLoan Details","Principal Amount (for first month)","Interest Amount (for first month)");
		
	  }                     



}
