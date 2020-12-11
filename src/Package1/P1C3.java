package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1C3 {

	public static void main(String[] args) {
		
		/*
		======== XPATH ========
		
		. Basic Syntax  : //tagname[@attribute='value']
		
		. Absolute XPath starts with '/'.
		  '/' in an XPath Expression searches for the immediate child node 
		  while locating the web elements on the page.
		
		. Relative XPath starts with '//'.
		  '//' in an XPath Expression searches for the immediate and next level child nodes 
		  while locating the web elements on the page.
		
		
		--------------------------------------------------------------------------------
		
		
		======== XPATH METHODS ========
		
		. contains()    : //[contains(@attribute,'value')]
		. text()        : //tagname[text()='text enclosed in tag']	
		. starts-with() : //tagname[starts-with(@attribute,'value')]
		
		
		--------------------------------------------------------------------------------
		
		
		======== INDEXING IN XPATH ========
		
		. Basic Syntax  : (//[contains(@attribute,'value')])[index]
		
		. Index starts with 1.
		
		
		--------------------------------------------------------------------------------
		
		
		======== OPERATORS IN XPATH ========
		
		. and  : //[@attribute='value' and @attribute='value']
		. or   : //[@attribute='value' or @attribute='value']
		
		
		--------------------------------------------------------------------------------
		
		
		======== XPATH AXES ========
		
		. Basic Syntax  : XPath/axes::target-element
		
		
		. ancestor :
		  Represents the ancestors of the current node which include the parents up to the root node.

        . ancestor-or-self : 
          Represents the current node and it's ancestors.

		. child : 
		  Represents the children of the current node.

		. descendant : 
		  Represents the descendants of the current node. 
		  Descendants include the node's children upto the leaf node(no more children).
	
		. descendant-or-self : 
		  Represents the current node and it's descendants.
	
		. following :
		  Represents all nodes that come after the current node.
	
		. following-sibling :
		  Represents the following siblings of the context node. 
		  Siblings are at the same level as the current node and share it's parent.

		. parent :
		  Represents the parent of the current node.

		. preceding :
		  Represents all nodes that come before the current node (i.e. before it's opening tag).
		  
		  
		--------------------------------------------------------------------------------
		
		
		======== REGEX WITH XPATH ========  
		
		. * : //*[@attribute='value']
		  * means 'Any Tag' with given attribute-value pair.
		  
		  
		--------------------------------------------------------------------------------
		
		
		======== XPATH / CSS SELECTOR VALIDATION ========
		
		.  $x("XPath")      - Type in console to validate XPath.
		
		*/
		
		
		// =========================================================================================
		
		
		// Exercise - Salesforce Login
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://login.salesforce.com/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Enter Username
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys("xyz");
		
		// Enter Password
		WebElement pass = driver.findElement(By.xpath("//input[@name='pw']"));
		pass.sendKeys("abc");
		
		// Click Login Button
		WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
		logIn.click();
		
		// Get Error Message
		String errorMsg = driver.findElement(By.xpath("//div[@id='error']")).getText();
		
		driver.quit();
		
		System.out.println(errorMsg);
		
	}

}
