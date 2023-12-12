package testPractice_Level01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Dropdown_02 {
	
  
  WebDriver driver;
  
  
  @Test
  public void f() {
	  
  }
  
  //Launching the Chrome browser
  @BeforeSuite
  public void beforeSuite() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://www.google.ca/");
	  driver.manage().window().maximize();
	  
	  
	  Thread.sleep(500);
	  
  }

  @AfterSuite
  public void afterSuite() {
	  
	  driver.close();
	  
  }

}
