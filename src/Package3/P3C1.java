package Package3;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class P3C1 {

	public static void main(String[] args) {
		
		// ======== EXERCISE - ADDING PRODUCTS TO CART DYNAMICALLY ======== 
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.get(baseUrl);
		
		// --------------------------------------------------------------------------------
		
		// Selecting Single Product
		
		/*
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name")); 
		
		for (WebElement product : products ) 
		{
			String name = product.getText();
			
			// Check desired product name and get its index. 
			if ( name.contains("Banana") ) 
			{
				int index = products.indexOf(product) + 1; // Index in Selenium starts with 1, so add 1 to product index.
				String xPath = String.format("(//div[@class='product-action']/button)[%d]", index);
				
				driver.findElement(By.xpath(xPath)).click(); // Click Add To Cart button of desired product.
				break;
			}
		}
		
		driver.quit();
		*/
		

		// --------------------------------------------------------------------------------
		
		
		// Selecting Multiple Products
		
		String [] itemsNeeded = {"Cucumber", "Tomato", "Capsicum", "Pumpkin", "Water Melon"};
		List<WebElement> allProducts = driver.findElements(By.cssSelector(".product-name")); 
		
		addItems(driver, itemsNeeded, allProducts);
		
		driver.quit();
		
	}

	
	// --------------------------------------------------------------------------------
	
	
	// Function To Select Multiple Products
	
	public static void addItems(WebDriver driver, String [] itemsNeeded, List<WebElement> allProducts) {
		
		int count = 0;

		for (WebElement product : allProducts ) 
		{
			List<String> itemsList = Arrays.asList(itemsNeeded); // Convert Array to ArrayList at runtime to save Memory.
			String productName = product.getText();
			
			// Format Product Name
			if ( productName.contains("-") ) 
				productName = productName.split("-")[0].trim(); // Extract Product Name excluding spaces.
			
			
			// Check For Desired Product
			if ( itemsList.contains(productName) ) 
			{
				// Locate Sibling Add To Cart Button Of Desired Product.
				String newXPath = String.format("//h4[contains(text(),'%s')]//following-sibling::div[2]/button", productName);
				
				driver.findElement(By.xpath(newXPath)).click();
				count++;
				
				// Break DOES NOT WORK With ArrayList So Use Counter To Exit Loop Once All Products Are Added.
				if ( count == itemsNeeded.length )
					break;
			}
		}
		
	} 
}
