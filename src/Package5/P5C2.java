package Package5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P5C2 {

	public static void main(String[] args) throws InterruptedException {
		
		// ======== HANDLING AUTO-SUGGESTIVE DROPDOWNS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.travolook.in/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		driver.findElement(By.id("flying_from_N")).click();
		WebElement fromLocation = driver.findElement(By.id("flying_from"));
		fromLocation.sendKeys("MUM");
		Thread.sleep(1000);
		fromLocation.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("flying_to_N")).click();
		WebElement toLocation = driver.findElement(By.id("flying_to"));
		toLocation.sendKeys("BANG");
		Thread.sleep(1000);
		toLocation.sendKeys(Keys.ENTER);
		
		driver.quit();

	}

}
