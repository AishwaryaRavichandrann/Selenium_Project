package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Inneriframe09 {
	
	ChromeDriver driver= new ChromeDriver();
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void f() {
		
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		WebElement Outer_Frame=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(Outer_Frame);
		WebElement Inner_Frame=driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(Inner_Frame);
		
		WebElement input_Element=driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		input_Element.sendKeys("Welcome Monster");
		
				
	}
	
	@AfterSuite
	public void afterSuite() throws Exception {
		
		Thread.sleep(5000);
		driver.close();
	}
}
