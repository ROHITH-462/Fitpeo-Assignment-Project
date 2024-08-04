package com.fitpeo.AutomationTestAssignment.Pages;

import org.openqa.selenium.WebDriver;

import com.fitpeo.AutomationTestAssignment.Base.BasePage;
import com.fitpeo.AutomationTestAssignment.Exceptions.MyException;
import com.fitpeo.AutomationTestAssignment.PageObjects.IRevenueCalculatorPageObject;

public class RevenueCalculatorPage extends BasePage implements IRevenueCalculatorPageObject {

	public RevenueCalculatorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	
	public void scrollDownToSliderSection() throws MyException {
		waitForVisibilityOfElementLocatable(driver, ROOT_SCROLLER);
		scrollToVisibleElement(MEDICAREELIGIBLE_TXT, driver);		
	}
	
	public void updateTheTextField(String noOfPatients) throws MyException {
		clearValueByKeyboardAction(PATIENT_COUNT_TXT_BOX);
//		setValueByJS("560",PATIENT_COUNT_TXT_BOX);
		setData(PATIENT_COUNT_TXT_BOX, noOfPatients);
	}
	
	public void scrollTillCPT_99091() throws MyException{
		waitForVisibilityOfElementLocatable(driver, CPT99091_TEXT);
		scrollToVisibleElement(CPT99091_TEXT, driver);
	}
	
	public void clickCPT99091Checkbox() throws MyException {
		clickElement(CPT99091_CHECKBOX);

	}
	
	public void clickCPT99453Checkbox() throws MyException {
		clickElement(CPT99453_CHECKBOX);
	}
	
	public void clickCPT99454Checkbox() throws MyException {
		clickElement(CPT99454_CHECKBOX);
	}
		
	public void scrollTillCPT_99474() throws MyException{
		waitForVisibilityOfElementLocatable(driver, CPT99474_TEXT);
		scrollToVisibleElement(CPT99474_TEXT, driver);
	}
	
	public void clickCPT99474CheckBox() throws MyException {
		clickElement(CPT99474_CHECKBOX);
	}
	
		
	public String getTotalReimbursementAmt() throws MyException {
		return  getText(TOTAL_RECURRING_REIMBURSEMENT_AMT_TXT);
	}
	
	public void getPatientsValue() throws MyException {
		System.out.println(getText(PATIENT_COUNT_TXT_BOX));
	}
	
	public void selectCPTCodes() throws MyException {
		try {
		scrollTillCPT_99091();
		clickCPT99091Checkbox();
		clickCPT99453Checkbox();
		clickCPT99454Checkbox();
		scrollTillCPT_99474();
		clickCPT99474CheckBox();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Error in selecting CPT Codes");
		}
	}
	
	
	
	
	

}
