package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iframe_08 {
	// frame is used to horizontally or vertically spliting the page into multiple section. Deprecated by HTML 5
	// iframe is used to insert content(video, imahe, textmeesage) of the extrenal website into the web page.
	
	//  Frames do not contain or support nested frames (frames within frames), but iFrames do contain nested iFrames.

	//we can't directly interact with the element present inside the iframe, first switch to the iframe then interact.
	
	@Test
	public void f() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		// To access the iframe , check the dom for the iframe elements with the iframe tag
		
		// Three ways to switch 
		// switch to frame - Name or id locator value directly in String
		driver.switchTo().frame("name of the frame");
		
		// switch to frame - Using WebElement
		WebElement frameElement= driver.findElement(By.xpath("//Span[1]"));
		driver.switchTo().frame(frameElement);		
		
		// switch to frame - Using integer
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//Span[1]")).click(); // element click
		driver.switchTo().defaultContent(); // Driver focused on the top window or first frame
		
		// In order to switch to another iframe, get back to the first frame then go to second frame
		

	}
}
