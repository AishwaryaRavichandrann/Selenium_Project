package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor_04 {

	public static void main(String[] args) throws Exception {

		// JavaScript Executor is an interface in selenium to execute Javascript through webdriver.
		// it has executescript method which helps to perform the following operations flash, highlight an webelement, 
		//to perform click action, generate an alert at the runtime, refreshing the page & getting title of the page, zoom in , zoom out
		// Scrolling up & down

		// It is used when selenium webdriver faces problem in interacting with webelement 
		// Sync issue, element is present in the webpage but it's not clickable, not visible.

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.google.ca");

		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("https://demo.nopcommerce.com/");
		
		//clickElementByJS 
		WebElement shoppingCart=driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
		JavaScriptUtil_04.clickElementByJS(shoppingCart,driver);
		driver.navigate().back();
		
		
		//Drawing border & take screenshot
		WebElement logo=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		JavaScriptUtil_04.drawBorder(logo, driver);
				
		//refreshing the page
		JavaScriptUtil_04.pageRefresh(driver);
		System.out.println(JavaScriptUtil_04.getTitleByJS(driver));
		//JavaScriptUtil_04.generateAlert(driver);
		JavaScriptUtil_04.scrollUp(driver);
		JavaScriptUtil_04.scrollDown(driver);
		Thread.sleep(5000);
		//JavaScriptUtil_04.zoomPage(driver);
		
		
		
		Thread.sleep(2000);
		driver.close();

	}
}