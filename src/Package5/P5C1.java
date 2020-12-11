package Package5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5C1 {

	public static void main(String[] args) {
		
		// ======== HANDLING TABLES ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.cricbuzz.com/live-cricket-scorecard/30475/rr-vs-srh-40th-match-indian-premier-league-2020";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Verify Whether Sum Of Runs Equals To Total Runs
		
		int runs = 0;
		int sum = 0;
		
		
		// Get Parent Table & Store Runs 
		WebElement table = driver.findElement(By.cssSelector("div[class= 'cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		
		List<WebElement> runsInTable = table.findElements(By.cssSelector(".cb-scrd-itms div:nth-child(3)")); // Gives Third Column Of Row.
		
		
		// Loop Over Runs To Get Sum
		for (int i=0; i<runsInTable.size()-2; i++) // Skip Last 2 Rows.
		{
			String value = runsInTable.get(i).getText();
			System.out.println("Run: " + value);
			
			int run = Integer.parseInt(value);
			runs += run;
		}
		
		
		// Get Extras
		String extrasString = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		System.out.println("Extras: " + extrasString);
		
		int extras = Integer.parseInt(extrasString);
		
		
		// Get Total
		String totalString = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		System.out.println("Total: " + totalString);
		
		int total = Integer.parseInt(totalString);
		
		
		// Add Runs & Extras To Get Sum Of Runs
		sum = runs + extras;
		System.out.println("Sum: " + sum);
		
		driver.quit();
		
	}

}
