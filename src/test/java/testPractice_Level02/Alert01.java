package testPractice_Level02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Alert01 {
	
	//Selenium webdriver can only automate the web application not the browser actions.
	
	// Alert is a method available in switchto()  - Simple, Confirm, Prompt and sweet alert 
	//unhandledAlertException , NoAlertPresentException
	
	ChromeDriver driver= new ChromeDriver();

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
	}

	@Test
	public void typesOfAlert() throws InterruptedException {
		
		
		// Simple alert - accept(), dismiss()
		driver.findElement(By.id("accept")).click();
		Alert Simple_alert= driver.switchTo().alert();
		Simple_alert.accept();
		Thread.sleep(2000);
		
		// Confirm alert
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		Alert Confirm_alert= driver.switchTo().alert();
		Confirm_alert.dismiss();
		
		//Prompt alert
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		Alert Prompt_alert= driver.switchTo().alert();
		System.out.println("The message displayed on the alert:  "+ Prompt_alert.getText());
		Prompt_alert.sendKeys("Hi LetCode");
		Prompt_alert.accept();
		
		
		
	}
		
	@AfterSuite
	public void afterSuite() throws Exception {
		Thread.sleep(2000);
		driver.close();
		
	}
}
