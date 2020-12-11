package Package6;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;


public class P6C2 {

	public static void main(String[] args) throws IOException {
		
		// ======== EXERCISE - HANDLING BROKEN LINKS WITH SOFT ASSERTION ========
		
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		String baseUrl = "https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(baseUrl);
		
		// -----------------------------------------------------------------------------------------
		
		SoftAssert sa = new SoftAssert();
		List <WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a")); // Get All Links Of Footer
		
		for (WebElement link : links) 
		{
			String linkUrl = link.getAttribute("href");
			
			URL url = new URL(linkUrl);  
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        
	        int respCode = conn.getResponseCode();
	        System.out.println(respCode);
	          
	        sa.assertTrue(respCode < 400, "The Link with text failed: " + link.getText() + ", with code: " + respCode);
		}
		
		sa.assertAll();
		
		driver.quit();
		
	}

}
