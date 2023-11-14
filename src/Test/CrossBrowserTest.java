package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	@Test(threadPoolSize = 2, invocationCount = 2, timeOut = 10000)
	@Parameters("browser")
	public void testApplication(String browser) {
		WebDriver driver;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\DriverForSelenuim\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\DriverForSelenuim\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\DriverForSelenuim\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\DriverForSelenuim\\operadriver.exe");
			driver = new OperaDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser value");
		}

		// Your test steps
		driver.get("https://www.google.com");

		driver.quit();
	}
}
