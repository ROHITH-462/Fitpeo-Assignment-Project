package com.fitpeo.AutomationTestAssignment.PageObjects;

import org.openqa.selenium.By;

public interface IRevenueCalculatorPageObject {
	
	By ROOT_SCROLLER = By.xpath("//span[contains(@class,'MuiSlider-root')]");
	By SCROLLER_BUTTON = By.xpath("//span[contains(@class,'MuiSlider-thumb')]");
	By MEDICAREELIGIBLE_TXT = By.xpath("//h4[contains(text(),'Medicare Eligible')]");
	By PATIENT_COUNT_TXT_BOX = By.xpath("//input[contains(@class,'MuiInputBase')]");
	
	By CPT99091_TEXT = By.xpath("//p[contains(text(),'CPT-99091')]");
	By CPT99091_CHECKBOX = By.xpath("//p[contains(text(),'CPT-99091')]/parent::div/label/span");
	
	By CPT99453_CHECKBOX = By.xpath("//p[contains(text(),'CPT-99453')]/parent::div/label/span[contains(@class,'Checkbox')]");
	By CPT99454_CHECKBOX = By.xpath("//p[contains(text(),'CPT-99454')]/parent::div/label/span[contains(@class,'Checkbox')]");		
			
	By CPT99474_TEXT = By.xpath("//p[contains(text(),'CPT-99474')]");
	By CPT99474_CHECKBOX = By.xpath("//p[contains(text(),'CPT-99474')]/parent::div/label/span[contains(@class,'Checkbox')]");
	
	By TOTAL_RECURRING_REIMBURSEMENT_AMT_TXT = By.xpath("//p[contains(text(),'Total Recurring')]/p");
	
	

}
