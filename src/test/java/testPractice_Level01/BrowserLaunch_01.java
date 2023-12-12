package testPractice_Level01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BrowserLaunch_01 {


	WebDriver driver;
	@Test
	public void f() {


	}

	//Launching the browser
	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.ca");

	}

	// Closing the browser
	@AfterSuite
	public void afterSuite() {

		driver.quit();
	}

}
