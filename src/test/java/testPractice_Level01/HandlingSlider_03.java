package testPractice_Level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingSlider_03 {
	
	ChromeDriver driver= new ChromeDriver();
	@BeforeTest
	public void beforetest() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		driver.get("https://www.google.ca");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
	}
	@Test
	public void test() {

		//getLocation ,dragAndDropBy -- handlingSlider
		
		WebElement Min_Slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		System.out.println("Location of the Slider "+Min_Slider.getLocation());
		System.out.println("Size of the web element "+Min_Slider.getSize());

		//To perform operations on Mouse , we use Actions class 
		Actions action= new Actions(driver);
		action.dragAndDropBy(Min_Slider, 120, 0).perform(); 
		// X value is 120 --> moving the cursor , Y value will be 0 --> no actions needed

		WebElement Max_Slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		action.dragAndDropBy(Max_Slider, -120, 0).perform(); 
		//action.dragAndDropBy(Max_Slider, -120, 0).build().perform(); // perform() method internally call build().perform()

	}
}
