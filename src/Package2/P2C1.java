package Package2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;


public class P2C1 {

	public static void main(String[] args) throws InterruptedException {

		// ======== HANDLING DROPDOWNS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.spicejet.com/";

		// --------------------------------------------------------------------------------
		
		// Handling Static Dropdown (Using Select Class)
		
		driver.get(baseUrl);
		 
		driver.findElement(By.id("divpaxinfo")).click();
		
		Select adult = new Select(driver.findElement(By.xpath("//select[contains(@name, 'Adult')]")));
		adult.selectByValue("5");
		
		Select child = new Select(driver.findElement(By.xpath("//select[contains(@name, 'Child')]")));
		child.selectByIndex(1);
		
		Select infant = new Select(driver.findElement(By.xpath("//select[contains(@name, 'Infant')]")));
		infant.selectByVisibleText("2");
		
		driver.quit();	
	
	}

}
