package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1C4 {

	public static void main(String[] args) {
		
		/*
		======== CSS SELECTOR ========
		
		. Basic Syntax      : tagname[attribute='value']
		. Syntax with ID    : tagname#id
		. Syntax with Class : tagname.class
		
		. Tagname is optional.
		
		 
		--------------------------------------------------------------------------------
		
		
		======== CSS SELECTOR VALIDATION ========
		
		. $("CSS Selector") - Type in console to validate CSS Selector.
		
		*/
		
		
		// =========================================================================================
		
		
		// Exercise - Salesforce Login
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://login.salesforce.com/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Enter Username
		WebElement username = driver.findElement(By.cssSelector("#username"));
		username.sendKeys("xyz");
		
		// Enter Password
		WebElement pass = driver.findElement(By.cssSelector("input.password"));
		pass.sendKeys("abc");
		
		// Click Login Button
		WebElement logIn = driver.findElement(By.cssSelector("input[type='submit']"));
		logIn.click();
		
		// Get Error Message
		String errorMsg = driver.findElement(By.cssSelector("div#error")).getText();
		
		driver.quit();
		
		System.out.println(errorMsg);
		
	}

}
