package testScenarios;

import mainFunctionalities.CarLoanFunctionalities;
import mainFunctionalities.HomeLoanFunctionalities;
import userDefinedLibraries.Utilities;

import org.testng.annotations.*;


public class TS_HomeLoan extends DriverSetup{

	public HomeLoanFunctionalities details2;
	public CarLoanFunctionalities details;
	public Utilities obj;

	@BeforeTest
	public void TC_initiateClasses()
	{
		details2 = new HomeLoanFunctionalities();
		details= new CarLoanFunctionalities();
		obj = new Utilities();
	}

	@Test(priority=1)  
	public void TC_homeLoanSelect()
	{
		details2.scrollUp();
		details.selectLoan("homeLoan");
		obj.snap("TS_HomeLoan1");
	}

	@Test(priority=2)
	public void TC_readHomeLoanData ()
	{
		details2.inputData("HomeLoan");
		obj.snap("TS_HomeLoan2");
	}

	@Test(priority=3)
	public void TC_scrollDown()
	{
		details2.scrollDown();
		obj.snap("TS_HomeLoan3");
	}

	@Test(priority=4)            
	public void TC_yearWiseData()
	{
		details2.writeYearWiseData();
		obj.snap("TS_HomeLoan4");
	}
}
