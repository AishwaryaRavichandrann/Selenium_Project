package testPractice_Level01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//SendKeys works only if dom has type="file" attribute present in the element path.
// Robot class

public class FileUpload_07 {
	ChromeDriver driver= new ChromeDriver();
	
	@BeforeSuite
	public void BeforeTest() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.foundit.in/");
	}
	
		
	/*
	 * @Test public void usingSendKeys() {
	 * 
	 * driver.findElement(By.xpath(
	 * "//*[@id=\"heroSection-container\"]/div[3]/div[2]/div[2]")).click();
	 * driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).
	 * sendKeys("C:\\Users\\kisho\\OneDrive\\Documents\\Medical certificate.pdf"); }
	 */
	
	@Test
	public void usingRobot() throws AWTException {
		
		driver.findElement(By.xpath("//*[@id=\"heroSection-container\"]/div[3]/div[2]/div[2]")).click();
		// driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).click(); --> WebDriver click() not gonna work since it's a alert
		
		// Using JS executeScript click()
		JavascriptExecutor js=driver;
		WebElement selectFile=driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
		js.executeScript("arguments[0].click();",selectFile);
		
		// put path of the file in a clipboard -- copy the path
		StringSelection ss = new StringSelection("C:\\Users\\kisho\\OneDrive\\Documents\\Medical certificate.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// using robot class -- control + V & Enter
		Robot robot= new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@AfterSuite
	public void AfterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
