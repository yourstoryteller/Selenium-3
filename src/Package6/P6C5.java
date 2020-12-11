package Package6;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class P6C5 {

	public static void main(String[] args) {
		
		// ======== WEB TABLE FILTER USING JAVA STREAMS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		String query = "Cheese"; 
		
		// Type Query In Search Box
		WebElement searchField = driver.findElement(By.id("search-field"));
		searchField.sendKeys(query);
		
		// Add Results To List
		List <WebElement> resultsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		// Filter Results To New List
		List <WebElement> filteredList = resultsList.stream().filter(p -> p.getText().contains(query)).collect(Collectors.toList());
		
		// Check Both List Sizes Are Equal Or Not
		Assert.assertEquals(resultsList, filteredList);
		
		driver.quit();
		
	}

}
