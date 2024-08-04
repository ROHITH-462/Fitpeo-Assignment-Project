package com.fitpeo.AutomationTestAssignment.Pages;

import org.openqa.selenium.WebDriver;

import com.fitpeo.AutomationTestAssignment.Base.BasePage;
import com.fitpeo.AutomationTestAssignment.Exceptions.MyException;
import com.fitpeo.AutomationTestAssignment.PageObjects.IHomePageObject;

public class HomePage extends BasePage implements IHomePageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String fetchPageTitle() throws MyException {
		return getPageTitle();
	}
	
	public void navigateToRevenueCalculatorPage() throws MyException {
		clickElement(REVENUECALCULATOR_LINK);
	}
	

	
	
	
	

}
