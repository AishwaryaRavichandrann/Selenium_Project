package testPractice_Level02;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PermissionPopUp03_chromeoptions {
	
	public static void main(String args[]) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver(options);  // options need to be passed as an argument
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		Thread.sleep(9000);
		driver.quit();
		driver.findElement(By.id("accept")); // NoSuchSessionException
	}
}
