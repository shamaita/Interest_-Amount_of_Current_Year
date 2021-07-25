package testScenarios;


import mainFunctionalities.CarLoanFunctionalities;
import mainFunctionalities.HomeLoanFunctionalities;
import userDefinedLibraries.Utilities;

import org.testng.annotations.*;

public class TS_PersonalLoan extends DriverSetup{

	public HomeLoanFunctionalities details2;
	public CarLoanFunctionalities details;
	public Utilities obj;

	@BeforeTest
	public void TC_initiateClasses()
	{
		details2 = new HomeLoanFunctionalities();
		details = new CarLoanFunctionalities();
		obj = new Utilities();
	}

	@Test(priority=1)
	public void TC_personalLoanSelect()
	{
		details.selectLoan("personalLoan");
		obj.snap("TS_PersonalLoan1");
	}

	@Test(priority=2)
	public void TC_enterDetails() {
		details.enterDetails("2000000","7.5","2");	
		obj.snap("TS_PersonalLoan2");
	}

	@Test(priority=3)
	public void TC_scrollDown()
	{
		details2.scrollDown();
		obj.snap("TS_PersonalLoan3");
	}

}
