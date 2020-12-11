package Package3;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class P3C4 {

	public static void main(String[] args) {
		
		// ======== HANDLING MULTIPLE WINDOWS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		driver.findElement(By.linkText("Privacy")).click();
		System.out.println(driver.getTitle()); // Print Parent Window Title.
		
		Set <String> ids = driver.getWindowHandles(); // Store Window Handles In Set.
		Iterator <String> it = ids.iterator(); // Use Iterator To Access Individual ID.
		String parentID = it.next();
		String childID = it.next();

		// Switch To Child Window
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle()); // Print Child Window Title.
		
		// Switch Back To Default Window
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle()); // Print Parent Window Title.
		
		driver.quit();

	}

}
