package testScenarios;

import mainFunctionalities.LoanCalculatorFunctionalities;


import org.testng.annotations.*;


public class TS_UICheck extends DriverSetup {
	public LoanCalculatorFunctionalities details3;



	@BeforeTest
	public void TC_initiateClasses()
	{
		details3 = new LoanCalculatorFunctionalities();

	}

	@Test(priority=1)
	public void TC_selectLoanCalculator(){
		details3.scrollUp();
		details3.selectLoanCalculator();


	}

	@Test(priority=2)
	public void TC_emiCalculator() throws Exception{
		details3.selectCalculator("emiCalculator");

		details3.checkLoanAmtTextBox("5000", config.getProperty("loanAmtTextBox"));
		details3.checkInterestRateTextBox("2.5", config.getProperty("interestRateTextBox"));
		details3.checkLoanTenureTextBox("6", config.getProperty("loanTenureTextBox"));
		details3.checkFeesChargesTextBox("5000", config.getProperty("feesChargesTextBox"));
		System.out.println("EMI Calculator textboxes are checked");

		details3.checkLoanAmtSlider(config.getProperty("loanAmtSlider"),config.getProperty("loanAmtTextBox"),"EMI Calculator");
		details3.checkInterestRateSlider(config.getProperty("interestRateSlider"),config.getProperty("interestRateTextBox"),"EMI Calculator");
		details3.checkLoanTenureSlider(config.getProperty("loanTenureSlider"),config.getProperty("loanTenureTextBox"),"EMI Calculator");
		details3.checkFeesChargesSlider(config.getProperty("feesChargesSlider"),config.getProperty("feesChargesTextBox"),"EMI Calculator");

	}

	@Test(priority=3)
	public void TC_loanAmountCalculator () throws Exception{
		details3.selectCalculator("loanAmountCalculator");

		details3.checkEMITextBox("4999.92", config.getProperty("emiTextBox"));
		details3.checkInterestRateTextBox("2.5", config.getProperty("interestRateTextBox"));
		details3.checkLoanTenureTextBox1("6", config.getProperty("loanTenureTextBox"));
		details3.checkFeesChargesTextBox("5000", config.getProperty("feesChargesTextBox"));
		System.out.println("Loan Amount Calculator textboxes are checked");

		details3.checkEMISlider(config.getProperty("emiSlider"),config.getProperty("emiTextBox"),"Loan Amount Calculator");
		details3.checkInterestRateSlider(config.getProperty("interestRateSlider"),config.getProperty("interestRateTextBox"),"Loan Amount Calculator");
		details3.checkLoanTenureSlider(config.getProperty("loanTenureSlider"),config.getProperty("loanTenureTextBox"),"Loan Amount Calculator");
		details3.checkFeesChargesSlider(config.getProperty("feesChargesSlider"),config.getProperty("feesChargesTextBox"),"Loan Amount Calculator");

	}
	@Test(priority=4)
	public void TC_loanTenureCalculator () throws Exception{
		details3.selectCalculator("loanTenureCalculator");

		details3.checkLoanAmtTextBox("5000", config.getProperty("loanAmtTextBox")); 
		details3.checkInterestRateTextBox("2.5", config.getProperty("interestRateTextBox"));
		details3.checkFeesChargesTextBox("5000", config.getProperty("feesChargesTextBox"));
		details3.checkEMITextBox("5010.42", config.getProperty("emiTextBox"));
		System.out.println("Loan Tenure Calculator textboxes are checked");

		details3.checkLoanAmtSlider(config.getProperty("loanAmtSlider"),config.getProperty("loanAmtTextBox"),"Loan Tenure Calculator");
		details3.checkEMISlider(config.getProperty("emiSlider"),config.getProperty("emiTextBox"),"Loan Tenure Calculator");
		details3.checkInterestRateSlider(config.getProperty("interestRateSlider"),config.getProperty("interestRateTextBox"),"Loan Tenure Calculator");
		details3.checkFeesChargesSlider(config.getProperty("feesChargesSlider"),config.getProperty("feesChargesTextBox"),"Loan Tenure Calculator");

	}


}
