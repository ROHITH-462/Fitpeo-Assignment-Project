package com.fitpeo.AutomationTestAssignment.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fitpeo.AutomationTestAssignment.Base.BaseTest;
import com.fitpeo.AutomationTestAssignment.Exceptions.MyException;
import com.fitpeo.AutomationTestAssignment.propertyfileloader.GlobalVars;

public class AssignmentTest extends BaseTest{
	
	@Test
	public void assignmentTest() throws MyException {
		
		//Navigate To Fitpeo Home Page
		System.out.println(homePage.fetchPageTitle());
		
		//Navigate To Revenue Calculator Page
		homePage.navigateToRevenueCalculatorPage();
		
		//Scroll Down To Slider Section
		revenueCalculatorPage.scrollDownToSliderSection();
		
		//Adjust The Slider
		revenueCalculatorPage.adjustTheSlidder();
		
		//Update The Text Field
		revenueCalculatorPage.updateTheTextField(GlobalVars.noOfPatients);
		
		//Validate Slider Value
		revenueCalculatorPage.getPatientsValue();
		
		//Select CPT Codes
		revenueCalculatorPage.updateTheTextField(GlobalVars.updatedNoOfPatients);
		revenueCalculatorPage.selectCPTCodes();
		
		//Validate Total Recurring Reimbursement
		Assert.assertEquals(GlobalVars.totalReimbursementAmt, revenueCalculatorPage.getTotalReimbursementAmt());
	}

}
