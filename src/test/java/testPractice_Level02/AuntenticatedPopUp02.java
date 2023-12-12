package testPractice_Level02;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AuntenticatedPopUp02 {
	
	// "https://username:password@link"
	ChromeDriver driver= new ChromeDriver();

	@BeforeSuite
	public void beforeSuite() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(9000);
	}

	@Test
	public void handlingPopUp() throws InterruptedException {
		
		String message=driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
		System.out.println(message);
	}
	
	@AfterSuite
	public void aftersuite() {
		driver.close();
	}

}
