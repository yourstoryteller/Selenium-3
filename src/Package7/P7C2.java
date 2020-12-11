package Package7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7C2 {

	public static void main(String[] args) throws InterruptedException {
		
		/* 
		======== HANDLING WINDOW AUTHENTICATION POPUPS WITH URL ========
		
		. Basic Syntax :
		  http://username:password@site-url
		
		*/
		
		
		// =========================================================================================
	
		// Exercise
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Modify Site URL To Handle Authentication
		String baseUrl = "http://admin:admin@the-internet.herokuapp.com/";
		driver.get(baseUrl);
		
		driver.findElement(By.partialLinkText("Auth")).click();
		
		driver.quit();

	}

}
