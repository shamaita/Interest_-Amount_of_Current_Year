package testScenarios;

import mainFunctionalities.CarLoanFunctionalities;
import userDefinedLibraries.Utilities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TS_CarLoan extends DriverSetup {

	public  CarLoanFunctionalities details;
	public Utilities obj;

	@BeforeTest
	public void TC_initiate() {
		details = new CarLoanFunctionalities();
		obj = new Utilities();

	}

	@Test(priority=1)
	public void TC_carLoanSelect() {
		details.selectLoan("carLoan");
		obj.snap("TS_CarLoan1");
	}

	@Test(priority=2)
	public void TC_enterDetails() {
		details.enterDetails("1500000","9.5","1");
		obj.snap("TS_CarLoan2");
	}

	@Test(priority=3)
	public void TC_selectMonth(){
		details.scrollDown();
		details.selectMonth();
		obj.snap("TS_CarLoan3");
	}

	@Test(priority=4)
	public void TC_displayResult() {
		details.printResult();
		obj.snap("TS_CarLoan4");
	}                                                         



}
