package Package5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class P5C4 {

	public static void main(String[] args) {
		
		// ======== HANDLING HTTPS (SSL) CERTIFICATIONS ========
		
		// Create DesiredCapabilities Object & Add Required Capabilities
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // OR dc.acceptInsecureCerts(); 
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		

		// Add DesiredCapabilities To Local Chrome Browser
		ChromeOptions ch = new ChromeOptions();
		ch.merge(dc);
		
		
		// Inject DesiredCapabilities Into Driver
		System.setProperty("webdriver.chrome.driver", "/home/shraddha/Desktop/Setups/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver(ch);
		driver.manage().window().maximize();

		String baseUrl = "http://www.google.com";
		driver.get(baseUrl);

		driver.quit();

	}

}
