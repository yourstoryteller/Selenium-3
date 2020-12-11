package Package4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P4C2 {

	public static void main(String[] args) {
		
		// ======== HANDLING FRAMES ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String baseUrl = "https://jqueryui.com/droppable/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		Actions ac = new Actions(driver);
		
		// Switch To Frame
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame"))); // By Web Element
		System.out.println(driver.findElements(By.tagName("iframe")).size()); // Get Total No. Of Frames
		driver.switchTo().frame(0); // By Frame Index
		
		// Drag and Drop Elements
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		ac.dragAndDrop(sourceElement, targetElement).build().perform();
		
		// Switch Back To Default Window
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@name='s']")).sendKeys("Done !");
		
		driver.quit();
		
	}

}
