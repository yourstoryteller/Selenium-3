package Package4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class P4C1 {

	public static void main(String[] args) {
		
		/*
		======== ACTION CLASS IN SELENIUM ========
		
		. Actions class is an ability provided by Selenium for handling keyboard and mouse events 
		  such as drag and drop, clicking on multiple elements with the control key. 
		
		. Basic Syntax :
		  Actions ac = new Actions(driver);
		    
		  
		--------------------------------------------------------------------------------
		
		
		======== MOUSE ACTIONS ========  
		
		. click()                                 : Clicks at the current mouse location.
		. doubleClick()                           : Performs a double-click at the current mouse location.
		. contextClick()                          : Performs a context-click at middle of the given element.
		. clickAndHold()                          : Clicks (without releasing) in the middle of the given element.
		. dragAndDrop(source, target)             : Click-and-hold at the location of the source element, moves to the location of the target element.
		. dragAndDropBy(source, xOffset, yOffset) : Click-and-hold at the location of the source element, moves by a given offset.
		. moveByOffset(x-offset, y-offset)        : Moves the mouse from its current position (or 0,0) by the given offset.
		. moveToElement(toElement)                : Moves the mouse to the middle of the element.
		. release()                               : Releases the depressed left mouse button at the current mouse location.
		
		
		--------------------------------------------------------------------------------
		
		
		======== KEYBOARD ACTIONS ======== 		
		
		. sendKeys() : Sends a series of keys to the element
		. keyUp()    : Performs key release
		. keyDown()  : Performs keypress without release  
		*/
		
		
		// =========================================================================================
		
		
		// Exercise - Amazon 
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.amazon.com/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Intialise Action Class Object 
		Actions ac = new Actions(driver);
		 
		// Declare WebElements
		WebElement signInDropDown = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		// Move To Dropdown Element
		ac.moveToElement(signInDropDown).build().perform(); 
		
		// Close Location Prompt
		ac.click(driver.findElement(By.cssSelector(".a-button-text"))).build().perform();
		
		// Enter Text In Uppercase In Search Box
		ac.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("iphone mini").build().perform();
			
		// Select Search Box Text
		ac.moveToElement(searchBox).click().keyDown(Keys.CONTROL).sendKeys("A").build().perform();
		
		// Quit Driver
		driver.quit();

	}

}
