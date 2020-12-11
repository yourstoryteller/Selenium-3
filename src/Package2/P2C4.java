package Package2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P2C4 {

	public static void main(String[] args) throws InterruptedException {
		
		// ======== HANDLING JAVASCRIPT ALERTS ======== 
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
			
		// --------------------------------------------------------------------------------
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Chandler Bing");
		
		// Open Alert and Click OK
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		alertBtn.click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		// Open Alert and Click Cancel
		WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));
		confirmBtn.click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.quit();
		
	}

}
