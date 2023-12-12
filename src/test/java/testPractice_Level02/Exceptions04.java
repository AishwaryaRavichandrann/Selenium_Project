package testPractice_Level02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exceptions04 {
	
	@Test
	public void f() {
		// Every DOM element is represented in webdriver by a unique identifying reference known as web element
		// NoSuchElementException --> Element is not present in the webpage to access.
		
		// StaleElementReferenceException --> when a page is navigated or refreshed, the referenced element is no longer attached to the DOM.
		// Refresh the page , handle it using try catch exception and locate the element again
		// use explicit wait to ensure the element is present before interacting it
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.name("q")); // switchTo()
		search.sendKeys("Hi"+Keys.ENTER); 
		
		search.clear(); // Trying to interact the element 
		
		// UnhandledAlertException --> Performing other operations before handling the alert
		// InvalidElementStateException --> trying to locate the element which is hidden
		// ElementNotInteractableException , ElementNotVisibleException --> is the subclass of InvalidElementStateException
		// toastr notification
		
		//NoSuchFrameException --> 
		//NoSuchSessionException --> Trying to perform any actions after closing the browser.
		driver.quit();
		driver.findElement(By.id("accept")); // NoSuchSessionException
		
		//NoSuchWindowException 
		//TimeOutException
		// SessionNotCreatedException --> browser killed before the run
		
		
		
		
	}
}
