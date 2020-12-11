package Package3;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class P3C3 {

	public static void main(String[] args) {

		// ======== FLUENT WAIT EXAMPLE ======== 
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(baseUrl);	
		
		// --------------------------------------------------------------------------------
		
		driver.findElement(By.cssSelector("#start button")).click(); // Click Start Button
		
		// Declare Fluent Wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								   .withTimeout(Duration.ofSeconds(12))
								   .pollingEvery(Duration.ofSeconds(4))
								   .ignoring(NoSuchElementException.class);
		
		// Use Fluent Wait
		WebElement msg = wait.until(new Function<WebDriver, WebElement>() {
        	 public WebElement apply(WebDriver driver) {
        		 WebElement finish = driver.findElement(By.cssSelector("#finish h4"));
        		 
        		 if (finish.isDisplayed()) return finish;
        		 else return null;
        	 }
        }); 
		
		System.out.println(msg.getText()); // Print Msg Text
		
		driver.quit();
		
	}

}
