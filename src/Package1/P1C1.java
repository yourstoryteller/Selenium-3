package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1C1 {

	public static void main(String[] args) {
		
		// ======== BASIC SELENIUM WEBDRIVER METHODS ========
		
		// Set Driver
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// Maximize Window
		driver.manage().window().maximize();
		
		// Delete All Cookies
		driver.manage().deleteAllCookies();
		
		// Hit Google URL
		String baseUrl = "http://www.google.com";
		driver.get(baseUrl);
		
		// Get Current URL
		String currentURL = driver.getCurrentUrl();
		// System.out.println(currentURL);
		
		// Get Page Title
		String pageTitle = driver.getTitle();
		// System.out.println(pageTitle);
		
		// Get Page Source
		String pageSource = driver.getPageSource();
		// System.out.println(pageSource);
		
		// Hit Facebook URL
		String facebookURL = "http://www.facebook.com";
		driver.get(facebookURL);
		
		// Go To Back Page
		driver.navigate().back();
		
		// Go To Next Page
		driver.navigate().forward();
		
		// Close Current Browser Window
		driver.close();
		
		// Quit Driver and Close All Windows
		driver.quit();
		
	}

}
