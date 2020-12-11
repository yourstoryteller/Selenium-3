package Package6;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class P6C4 {

	public static void main(String[] args) {
		
		// ======== WEB TABLE SORT USING JAVA STREAMS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Select No. Of Table Rows To Be Displayed
		Select pageSize = new Select(driver.findElement(By.id("page-menu")));
		pageSize.selectByValue("10");
		
		// Click On Sort Column
		driver.findElement(By.xpath("//table//th[1]")).click();
		
		// Get All Products In A List
		List <WebElement> elementsList = driver.findElements(By.xpath("//table//tr/td[1]"));
		
		// Extract Product Names To Another List Using Stream
		List<String> originalList =  elementsList.stream().map(p -> p.getText()).collect(Collectors.toList());
		
		// Sort the Original List Using Stream
		List<String> sortedList =  originalList.stream().sorted().collect(Collectors.toList());
		
		// Check Whether Both Lists Are Equal Or Not
		Assert.assertTrue(originalList.equals(sortedList));
		
		// Using Custom Method To Get Price Of All Products
		List <String> priceList = elementsList.stream().map(p -> getPrice(p)).collect(Collectors.toList());
		System.out.println(priceList);
		
		driver.quit();
		
	}
	
	
	// --------------------------------------------------------------------------------
	
	
	// Method To Get Price Of Product
	private static String getPrice(WebElement p) {
		String price = p.findElement(By.xpath("following-sibling::td")).getText();
		return price;
	}
	
}
