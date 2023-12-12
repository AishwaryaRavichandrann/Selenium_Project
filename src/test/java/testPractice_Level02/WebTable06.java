package testPractice_Level02;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTable06 {
	
	ChromeDriver driver= new ChromeDriver();
	@BeforeSuite
	public void beforeSuite() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
	}

	
	@Test
	public void test() throws Exception {
		
	
		//Number of header
		WebElement table=driver.findElement(By.id("simpletable"));
		List<WebElement> header=table.findElements(By.tagName("th"));
		Thread.sleep(2000);
		for(WebElement e:header) {
			System.out.println(e.getText());
			
		}
			
		
		driver.close();
		
		
	}
}
