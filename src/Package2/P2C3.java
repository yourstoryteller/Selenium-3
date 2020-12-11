package Package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2C3 {

	public static void main(String[] args) {
		
		// ======== HANDLING CALENDAR UI ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.travolook.in/";
		driver.get(baseUrl);

		// --------------------------------------------------------------------------------
		
		// Select Current Date
		driver.findElement(By.id("Fly_depdate_val")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		driver.quit();

	}

}
