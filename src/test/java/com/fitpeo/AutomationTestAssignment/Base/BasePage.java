package com.fitpeo.AutomationTestAssignment.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fitpeo.AutomationTestAssignment.Exceptions.MyException;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;




	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		actions = new Actions(driver);
	}


	//----------------------CLICK OPERATION---------------------------
	public void clickElement(By webElement) throws MyException {
		try{
			driver.findElement(webElement).click();		
		}catch (Exception e) {
			throw new MyException("Unable to click element");
		}
	}

	//----------------------CLEAR DATA---------------------------
	public void clearData(By webElement) throws MyException {
		try {
			driver.findElement(webElement).clear();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable to clear the value");
		}
	}

	//----------------------GET TEXT------------------------------------
	public String getText(By webElement) throws MyException {
		try {
			return driver.findElement(webElement).getText();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable to retrieve Text");
		}
	}

	//----------------------GET PAGE TITLE------------------------------------
	public String getPageTitle() throws MyException {
		try {
			return driver.getTitle();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable to fetch title of the page");
		}
	}

	//----------------------SLIDE THE SLIDDER------------------------------------
	public void adjustTheSlidder() throws MyException {
		try {
			WebElement slidderRoot = driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']"));
			WebElement slidder = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
			//actions.dragAndDropBy(slidder, 0, 0).perform();
			int width = slidderRoot.getSize().getWidth();
			int targetAxis = width/3;
			//			System.out.println("Width : "+ width);
			actions.dragAndDropBy(slidder, targetAxis, 0).perform();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable To Adjust the slidder");
		}
	}


	//----------------------SENDDATA OPERATION--------------------------
	public void setData(By webElement, String value) throws MyException {
		try {
			driver.findElement(webElement).clear();
			driver.findElement(webElement).sendKeys(value);
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable to set data");
		}
	}

	//----------------------SCROLL OPERATION--------------------------
	public void scrollToVisibleElement(By scrollLink, WebDriver driver) throws MyException {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(scrollLink));
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Unable to scroll");
		}
	}

	//-------------------------------------WAITS-------------------------------------------------
	public void waitForVisibilityOfElementLocatable(WebDriver driver, By locators) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
	}

	//-------------------------------------DRAG AND DROP-------------------------------------------------	
	public void dragAndDrop() throws MyException {
		try {
			WebElement fromSourceLocator = driver.findElement(By.xpath("ROOT_SCROLLER"));
			WebElement toDestinationLocator = driver.findElement(By.xpath(""));
			actions.dragAndDrop(fromSourceLocator, toDestinationLocator);
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Error in drag and drop");
		}
	}

	//-------------------------------------SET VALUE BY JAVASCRIPT-------------------------------------------------
	public void setValueByJS(String noOfPatients, By webElement) throws MyException {
		try {
			WebElement setNoOfPatients = driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase')]"));
			setNoOfPatients.clear();
			js = (JavascriptExecutor) driver;
			driver.findElement(webElement).clear();
			driver.findElement(webElement).sendKeys(noOfPatients);
			js.executeScript("arguments[0].value='';",setNoOfPatients);
			js.executeScript("arguments[0].value=arguments[1];",setNoOfPatients,noOfPatients);
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Error in set data using Java Script");
		}
	}


	//-------------------------------------CLEAR VALUE USING BACKSPACE ACTION-------------------------------------------------
	public void clearValueByKeyboardAction(By webElement) throws MyException {
		try {
			driver.findElement(webElement).click();
			actions.click(driver.findElement(webElement)).keyDown(Keys.CONTROL)
			.sendKeys("a")
			.keyUp(Keys.CONTROL)
			.sendKeys(Keys.BACK_SPACE)
			.build()
			.perform();
		}catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Error in clearing the data using action class");
		}
	}

}
