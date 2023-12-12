package testPractice_Level01;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShot_05 {
	
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kisho\\OneDrive\\Desktop\\Selenium_Project\\Selenium_Practice\\src\\test\\resources\\webDrivers\\chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.google.ca");
		
		driver.manage().window().maximize();
		
		// We aren't performing Casting in this line,driver instance created for ChromeDriver class. 
		TakesScreenshot ts = driver;  
		File SourceFile=ts.getScreenshotAs(OutputType.FILE); // Mentioning the output file type - file format
		File DestinationFile= new File("C:\\Users\\kisho\\OneDrive\\Desktop\\Sample.png");
		FileHandler.copy(SourceFile, DestinationFile);
		//FileUtils.copyFile(SourceFile, DestinationFile); we need common.io Jar
		
		//Taking Screenshot, while alert is not handled properly, it will throw an unhandledAlert Exception.
		
		//To take Full ScreenShot including address bar and the tab which are opened - ROBOT Class
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); // import from AWT
		Rectangle rec = new Rectangle(screenSize);
		
		Robot robot= new Robot();
		BufferedImage SourceFile01=robot.createScreenCapture(rec);
		File DestinationFile01= new File("C:\\Users\\kisho\\OneDrive\\Desktop\\Sample_Robot.png");
		// FileHandler can't handle bufferedimage & file instead file & file can be handled
		ImageIO.write(SourceFile01,"png", DestinationFile01);
		Thread.sleep(2000);
		driver.close();		
	}
}


