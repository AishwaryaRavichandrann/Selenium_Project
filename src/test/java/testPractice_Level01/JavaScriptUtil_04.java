package testPractice_Level01;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;


public class JavaScriptUtil_04 {
	
	// To perform repeated actions in JavaScript executor,for each action, create a reusable methods in a separate class. 
	// call those methods from utility class. 
	
	// Highlighting the webelement ----> arguments[0].style.border='3px soild red' , element
	// PageRefresh ---->				 history.go(0)
	// ClickElement ----> 				 arguments[0].click();
	// Title of the webpage ----> 		 return document.title;
	// Generate an alert ---->           alert()
	// Scrolling the page up ---->       window.scrollTo(0, document.body.scrollHeight) -----> scrollTo
	// Scrolling the page down ---->     window.scrollBy(0, -document.body.scrollHeight) ----> scrollBy
	// ZoomPage ----> 					 document.body.style.zoom='50%'
	
	@Test
	public static void drawBorder(WebElement element,WebDriver driver) throws IOException { // User defined method
		
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].style.border='3px solid red'",element); // arguments not argument
		
		TakesScreenshot ts = (TakesScreenshot) driver;  
		File SourceFile=ts.getScreenshotAs(OutputType.FILE); // Mentioning the output file type - file format
		File DestinationFile= new File("C:\\Users\\kisho\\OneDrive\\Desktop\\Sample.png");
		FileHandler.copy(SourceFile, DestinationFile);
	}
	
	@Test
	public static void pageRefresh(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("history.go(0)");
	}
	
	@Test
	public static void clickElementByJS(WebElement shoppingCart,WebDriver driver) throws InterruptedException {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].click();",shoppingCart); 
		Thread.sleep(2000);
		String condition=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")).getText();
		System.out.println(condition);
		//assert.assertEquals(condition,"Your Shopping Cart is empty!");
		
	}
	
	public static Object getTitleByJS(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		return Js.executeScript("return document.title;");
		
	}
	
	public static void generateAlert(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		String message="This is my alert...";
		Js.executeScript("alert('" + message + "')"); // alert() works too but alert("") alert('""') won't work. 
	}
	
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");  
	}
	
	public static void zoomPage(WebDriver driver) {
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("document.body.style.zoom='50%'"); 
	}
	
}
