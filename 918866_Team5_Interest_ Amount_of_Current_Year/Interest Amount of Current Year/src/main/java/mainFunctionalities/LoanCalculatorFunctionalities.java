package mainFunctionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import userDefinedLibraries.Utilities;
import userDefinedLibraries.CheckFields;


public class LoanCalculatorFunctionalities extends Utilities 

{
	CheckFields ch=new CheckFields();
	
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
	   * Selection of Loan Calculator Option from the main menu
	   */
	public void selectLoanCalculator()
	{
		waitElementClickable(config.getProperty("loanCalculator"));
		driver.findElement(By.xpath(config.getProperty("loanCalculator"))).click();
		driver.navigate().refresh();
		waitElementClickable(config.getProperty("loanCalculator"));
		driver.findElement(By.xpath(config.getProperty("loanCalculator"))).click();
	}
	
	/*
	 * Selection of required calculator option under Loan Calculator
     */
	public void selectCalculator(String xpath)
	{
		waitElementClickable(config.getProperty(xpath));
		driver.findElement(By.xpath(config.getProperty(xpath))).click();
	}
	
	/*
	 * UI check for Loan Amount text box 
	 */
	public void checkLoanAmtTextBox(String amount, String xpath) 
	{
		ch.checkText(amount, xpath);
	}
	
	/*
	 * UI check for Interest Rate text box 
	 */
	public void checkInterestRateTextBox(String amount, String xpath)
	{
		ch.checkText(amount, xpath);
	}
	
	/*
	 * UI check for Loan Tenure text box 
	 */
	public void checkLoanTenureTextBox(String amount, String xpath)
	{
		WebElement tenure = ch.checkText(amount, xpath);
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement month = driver.findElement(By.xpath(config.getProperty("month")));
		wait.until(ExpectedConditions.elementToBeClickable(month));
		month.click();
		Assert.assertEquals(tenure.getAttribute("value"), "72");
	}
	
	/*
	 * UI check for Loan Tenure text box 
	 */
	public void checkLoanTenureTextBox1(String amount, String xpath) {
		WebElement tenure = ch.checkText(amount, xpath);
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement month = driver.findElement(By.xpath(config.getProperty("month")));
		wait.until(ExpectedConditions.elementToBeClickable(month));
		month.click();
		Assert.assertEquals(tenure.getAttribute("value"), "6");
		
	}
	
	/*
	 * UI check for Fees & Charges text box 
	 */
	public void checkFeesChargesTextBox(String amount, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		ch.checkText(amount, xpath);
	}
	
	/*
	 * UI check for EMI text box 
	 */
	public void checkEMITextBox(String amount, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		ch.checkText(amount, xpath);
	}
	
	/*
	 * UI check for Loan Amount slider
	 */
	public void checkLoanAmtSlider(String str1, String str2,String name) throws InterruptedException
	{
		String x=ch.checkSlider(str1,str2);
		System.out.println(name+" slider for loan amount is working and the value is being reflecting in the textbox: "+x);
	}
	
	/*
	 * UI check for Interest Rate slider
	 */
	public void checkInterestRateSlider(String str1, String str2,String name) throws InterruptedException 
	{
		String x=ch.checkSlider( str1, str2);
		System.out.println(name+" slider for loan interest is working and the value is being reflecting in the textbox: "+x);
    }
	
	/*
	 * UI check for Loan Tenure slider
	 */
	public void checkLoanTenureSlider(String str1, String str2,String name) throws InterruptedException 
	{
		String x=ch.checkSlider(str1, str2);
		System.out.println(name+" slider for loan tenure is working and the value is being reflecting in the textbox: "+x);
	}
	
	/*
	 * UI check for Fees & Charges slider
	 */
	public void checkFeesChargesSlider(String str1, String str2,String name) throws InterruptedException 
	{
	    String x=ch.checkSlider(str1, str2);
		System.out.println(name+" slider for loan fees is working and the value is being reflecting in the textbox: "+x);
	}
	
	/*
	 * UI check for EMI slider
	 */
	public void checkEMISlider(String str1, String str2,String name)throws InterruptedException 
	{
	    String x=ch.checkSlider(str1, str2);
		System.out.println(name+" slider for loan emi is working and the value is being reflecting in the textbox: "+x);
	}
	
	
}
