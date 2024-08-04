package com.fitpeo.AutomationTestAssignment.Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fitpeo.AutomationTestAssignment.Pages.HomePage;
import com.fitpeo.AutomationTestAssignment.Pages.RevenueCalculatorPage;
import com.fitpeo.AutomationTestAssignment.propertyfileloader.PropertyFileLoader;


public class BaseTest {
	
	protected WebDriver driver;

	protected HomePage homePage;
	protected RevenueCalculatorPage revenueCalculatorPage;


	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void setUp() throws IOException {
		PropertyFileLoader propFileLoader = PropertyFileLoader.getInstance();
		if(propFileLoader.browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", propFileLoader.chromeDriver);
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(propFileLoader.url);
		
		homePage = new HomePage(driver);
		revenueCalculatorPage = new RevenueCalculatorPage(driver);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
