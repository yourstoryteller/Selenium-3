package Package4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4C3 {

	public static void main(String[] args) {
		
		// ======== LIMITNG WEBDRIVER SCOPE ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Get Count Of Total Links On Webpage
		int totalLinks = driver.findElements(By.tagName("a")).size();
		System.out.println(totalLinks);
		
		
		// Get Count Of Total Links On Footer
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		
		int footerLinks = footer.findElements(By.tagName("a")).size(); // By Limiting WebDriver Scope To Footer
		System.out.println(footerLinks);
		
		
		// Get Count Of Total Links On Footer's First Section
		WebElement firstSection = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		int firstSectionLinks = firstSection.findElements(By.tagName("a")).size();
		System.out.println(firstSectionLinks);
		
		
		// Check Whether Links Are Working
		for ( int i=1; i<firstSectionLinks; i++ ) 
		{
			String openNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // Keys.chord() Handles Multiple Keyboard Keys. 
			firstSection.findElements(By.tagName("a")).get(i).sendKeys(openNewTab);
		}
		
		// Print Page Title Of All Open Tabs
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		
		while ( it.hasNext() )
		{
			String tab = it.next();
			driver.switchTo().window(tab);
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
		
	}

}
