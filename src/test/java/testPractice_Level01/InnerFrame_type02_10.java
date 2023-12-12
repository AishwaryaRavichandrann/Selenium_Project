package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class InnerFrame_type02_10 {
	ChromeDriver driver= new ChromeDriver();

	@BeforeSuite
	public void beforeSuite() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.manage().window().maximize();
	}

	@Test
	public void f() {

		
		driver.switchTo().frame("iframeResult");
		WebElement Inner_Frame=driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(Inner_Frame);
		String Text=driver.findElement(By.xpath("/html/body/h1")).getText();
		System.out.println(Text);
		
		driver.switchTo().parentFrame();
		String parentText=driver.findElement(By.xpath("/html/body/p")).getText();
		System.out.println(parentText);


	}

	@AfterSuite
	public void afterSuite() throws Exception {

		Thread.sleep(5000);
		driver.close();
	}
}
