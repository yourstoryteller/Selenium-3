package Package6;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P6C1 {

	public static void main(String[] args) throws IOException {
			
		// ======== TAKING SCREENSHOTS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.udemy.com/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Convert Driver Object To Take Screenshot
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		
		// Capture Screenshot
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		
		// Create New File With Destination Path
		String root = System.getProperty("user.dir");
		File destFile = new File(root+"/screenshot.png");
		
		// Copy Screenshot To Destination File
		FileUtils.copyFile(srcFile, destFile);
		
		driver.quit();
		
	}

}
