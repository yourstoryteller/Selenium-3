package Package5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class P5C3 {

	public static void main(String[] args) throws InterruptedException {
		
		/* 
		======== JAVASCRIPTEXECUTOR ========
		
		. JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver. 
		
		. Basic Syntax :
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		
		*/
		
		
		// =========================================================================================
		
		
		// Exercise
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		// Initialize JavascriptExecutor Object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Get Webpage Title
		String pageTitle = (String) js.executeScript("return document.title;");
		System.out.println(pageTitle);
		
		// Tick Checkbox
		js.executeScript("document.getElementById(\"checkBoxOption3\").click();");
		
		// Enter Input
		js.executeScript("document.getElementById(\"name\").value=\"Shraddha\";");

		// Scroll Page
		js.executeScript("window.scrollBy(0,400);");
		
		driver.quit();
		
	}

}
