package Package4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P4C4 {

	public static void main(String[] args) throws InterruptedException {
		
		// ======== EXERCISE - HANDLING CALENDAR UI DYNAMICALLY ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.path2usa.com/travel-companions";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------	

		// Declare Desired Date (Date, Month & Year)
		String day, monthYear;
		
		day = "16";
		monthYear = "February 2021";
	
		
		// Wait For Page To Load & Open Calendar
		Thread.sleep(5000);
		
		WebElement calendar = driver.findElement(By.id("travel_date"));
		calendar.click();
		
		
		// Click Next Button Until We Reach Desired Month & Year
		WebElement monthYearInput = driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch"));
		String monthYearText = monthYearInput.getText();	
		
		while (!monthYearText.contains(monthYear)) // Check Dispayed Month, Year Matches With Desired Month, Year.
		{
			WebElement nextBtn = driver.findElement(By.cssSelector(".datepicker-days .next"));
			nextBtn.click();
			
			monthYearText = monthYearInput.getText(); // Update Dispayed Month, Year.
		}
		
		
		// Get All Days And Select Desired Day
		List <WebElement> days = driver.findElements(By.cssSelector(".day")); // Store All Displayed Days
		int daysCount = days.size();
		
		for (int i=0; i<daysCount; i++) 
		{
			String dayText = days.get(i).getText();
			if (dayText.equalsIgnoreCase(day))  // Check Current Iteration's Day Matches With Desired Day.
			{
				days.get(i).click();
				break;
			}
		}
		
		
		// Print Selected Date & Quit Driver
		System.out.println(calendar.getAttribute("value"));
		
		driver.quit();
		
	}

}
