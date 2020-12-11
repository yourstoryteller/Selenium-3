package Package2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P2C2 {

	public static void main(String[] args) throws InterruptedException {
		
		// ======== HANDLING CHECKBOXES & RADIO BUTTONS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl;

		// --------------------------------------------------------------------------------
		
		// Handling Checkbox 
		
		/*
		baseUrl = "https://paytm.com/flights";
		driver.get(baseUrl);
		 
		driver.findElement(By.id("chkArmy")).click();
		
		driver.findElement(By.id("chkStudent")).click();
		
		driver.findElement(By.id("chkSeniorCitizen")).click();
		
		driver.findElement(By.id("chkDoctors")).click();
		
		driver.quit();
		*/
		
		
		// --------------------------------------------------------------------------------
		
		// Handling Radio Button
		
		/*
		baseUrl = "https://www.budgetticket.in/home";
		driver.get(baseUrl);
		
		Thread.sleep(2000); // 1 second = 1000 milli seconds
		
		driver.findElement(By.xpath("//label[text()='Round Trip']")).click();
		
		driver.quit();
		*/
		
		

	}

}
