package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1C2 {

	public static void main(String[] args) {
		
		/*
		======== LOCATORS IN SELENIUM ========
		 
	 	. ID
		. Class
		. Name
		. Link Text
		. Partial Link Text
		. XPath
		. CSS Selector
		 
		*/
		
		
		// =========================================================================================
		
		
		// Exercise - Facebook Login
		
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "http://www.facebook.com";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Enter Email
		WebElement email =  driver.findElement(By.id("email")); // Find Element by ID
		email.sendKeys("xyz@abc.com");
		
		// Enter Password
		WebElement pass = driver.findElement(By.name("pass")); // Find Element by Name
		pass.sendKeys("password");
		
		// Click Login Button
		WebElement logIn = driver.findElement(By.xpath("//button[1]")); // Find Element by XPath
		logIn.click();
		
		// Click Forgotten Password
		// WebElement forgotPass = driver.findElement(By.linkText("Forgotten password?")); // Find Element by Link Text
		WebElement forgotPass = driver.findElement(By.partialLinkText("Forgot")); // Find Element by Partial Link Text
		forgotPass.click();
		
		driver.quit();

	}

}
