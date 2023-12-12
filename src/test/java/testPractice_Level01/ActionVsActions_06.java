package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionVsActions_06 {
	
	ChromeDriver driver= new ChromeDriver();
	@BeforeTest
	public void beforetest() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
		driver.get("https://www.amazon.ca/");
	}
	@Test
	public void test() {
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")); 
		
		//Actions is a class which contains methods to perform operations on Mouse
		Actions action= new Actions(driver);
		action.moveToElement(element).perform(); // which is same as build().perform();
		
		//Action is an iterface, a variable of Action 'act' stores the action 
		Action act=action.moveToElement(element).build(); 
		act.perform();

	}
}
