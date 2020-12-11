package Package3;

import Package3.P3C1;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class P3C2 {

	public static void main(String[] args) {
		
		/*
		======== WAITS IN SELENIUM ========
		
		. Implicit Wait
		. Explicit Wait
		. Fluent Wait
		
		
		--------------------------------------------------------------------------------
		
		
		======== IMPLICIT WAIT ========
		
		. Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before throwing "No Such Element Exception". 
		
		. Once this time is set, Selenium WebDriver will wait for every element before the exception occurs.
		
		. Basic Syntax :
		  import java.util.concurrent.TimeUnit;
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		--------------------------------------------------------------------------------
		
		
		======== EXPLICIT WAIT ========
		
		. Explicit Wait directs the Selenium WebDriver to wait until a certain condition occurs before proceeding with executing the code.
		
		. Explicit wait is more intelligent, but can only be applied for specified elements. 
		  However, it is an improvement on implicit wait since it allows the program to pause for dynamically loaded Ajax elements.
		  
		. Expected Conditions in Explicit Wait are :
		  - alertIsPresent()
          - elementSelectionStateToBe()
		  - elementToBeClickable()
		  - elementToBeSelected()
		  - frameToBeAvaliableAndSwitchToIt()
		  - invisibilityOfTheElementLocated()
		  - invisibilityOfElementWithText()
		  - presenceOfAllElementsLocatedBy()
		  - presenceOfElementLocated()
		  - textToBePresentInElement()
		  - textToBePresentInElementLocated()
		  - textToBePresentInElementValue()
		  - titleIs()
		  - titleContains()
		  - visibilityOf()
		  - visibilityOfAllElements()
		  - visibilityOfAllElementsLocatedBy()
		  - visibilityOfElementLocated()  
		  
		. Basic Syntax :
		  import org.openqa.selenium.support.ui.ExpectedConditions
		  import org.openqa.selenium.support.ui.WebDriverWait 
		  
		  WebDriverWait wait = new WebDriverWait(driver,30);		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
		  
		
		--------------------------------------------------------------------------------
		
		
		======== FLUENT WAIT ========  
		
		. The Fluent Wait command defines the maximum amount of time for Selenium WebDriver to wait for a certain condition to appear. 
	 	  It also defines the frequency with which WebDriver will check if the condition appears before throwing the �ElementNotVisibleException�.
	 	
	 	. To put it simply, Fluent Wait looks for a web element repeatedly at regular intervals until timeout happens or until the object is found.
	 	
	 	. Basic Syntax :
	 	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
          .withTimeout(Duration.ofSeconds(12))
          .pollingEvery(Duration.ofSeconds(4))
          .ignoring(NoSuchElementException.class);

   		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
         	 public WebElement apply(WebDriver driver) {
         	 	 return driver.findElement(By.id("foo"));
         	 }
         });  
		*/
		
		
		// =========================================================================================
		
		
		// Exercise
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Declare Implicit Wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Declare Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/";
		driver.get(baseUrl);
		
		// --------------------------------------------------------------------------------
		
		// Add Products to Cart
		String [] itemsNeeded = {"Cucumber", "Tomato", "Capsicum"};
		List<WebElement> allProducts = driver.findElements(By.cssSelector(".product-name")); 
		
		P3C1.addItems(driver, itemsNeeded, allProducts);
		
		
		// Checkout Products
		driver.findElement(By.xpath("//img[@alt='Cart']")).click(); // Click On Cart Icon	
		driver.findElement(By.xpath("//div[contains(@class,'cart-preview')]//button")).click(); // Click On Proceed To Checkout Button
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // Use Explicit Wait For Visibility of Element
		WebElement promoCodeInput = driver.findElement(By.cssSelector("input.promoCode"));
		promoCodeInput.sendKeys("rahulshettyacademy"); // Enter Promo Code
			
		driver.findElement(By.cssSelector("button.promoBtn")).click(); // Click On Apply Button
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // Use Explicit Wait For Visibility of Element
		WebElement promoInfo = driver.findElement(By.cssSelector("span.promoInfo"));
		System.out.println(promoInfo.getText());
		
		driver.quit();

	}

}
