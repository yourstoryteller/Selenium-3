package Package7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P7C3 {

	public static void main(String[] args) {
		
		// ======== FILE UPLOADING USING SENDKEYS ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://the-internet.herokuapp.com/upload";
		driver.get(baseUrl);
		
		// --------------------------------------------------------------------------------
		
		String path = "/home/shraddha/Desktop/Books/Beartown.pdf";
		WebElement file = driver.findElement(By.id("file-upload"));
		WebElement submitBtn = driver.findElement(By.id("file-submit"));
		
		file.sendKeys(path);
		submitBtn.click();
		
		String msg = driver.findElement(By.cssSelector("#content h3")).getText();
		System.out.println(msg);

	}

}
