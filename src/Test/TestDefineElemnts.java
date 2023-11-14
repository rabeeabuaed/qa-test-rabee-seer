package Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class TestDefineElemnts {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws Exception {
		switch (browser.toLowerCase()) {
		case "chrome":
			launchChrome();
			break;
		case "firefox":
			launchFirefox();
			break;
		case "edge":
			launchEdge();
			break;
		case "opera":
			launchOpera();
			break;
		default:
			throw new Exception("Invalid browser specified: " + browser);
		}
	}

	private void launchChrome() {
		System.out.println("Launching Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\DriverForSelenuim\\Chrome\\chromedriver.exe");
		driver.set(new ChromeDriver());
	} 

	private void launchFirefox() {
		System.out.println("Launching Firefox Browser");
		System.setProperty("webdriver.gecko.driver", "C:\\DriverForSelenuim\\geckodriver.exe");
		driver.set(new FirefoxDriver());
	}

	private void launchEdge() {
		System.out.println("Launching Edge Browser");
		System.setProperty("webdriver.edge.driver", "C:\\DriverForSelenuim\\msedgedriver.exe");
		driver.set(new EdgeDriver());
	}

	private void launchOpera() {
		System.out.println("Launching Opera Browser");
		System.setProperty("webdriver.opera.driver", "C:\\DriverForSelenuim\\operadriver.exe");
		driver.set(new OperaDriver());
	}

	@DataProvider(name = "userDataProvider")
	public Object[][] userDataProvider() {
		return new Object[][] {
			// values in each row: {  "name", "phone", "email", "country", "city", "username", "password"}
									{ "rabee", "971581783536", "rabee@gmail.com", "Guam", "damascus", "rabeeabuaed", "Rabe_1992" },

				// Add more rows with different sets of data
		};
	}

	@Test(dataProvider = "userDataProvider")
	public void registerNewUser(String name, String phone, String email, String country, String city, String username,
			String password) throws Exception {
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get().get("https://way2automation.com/way2auto_jquery/index.php");
		driver.get().manage().window().maximize();
		defineElements object = new defineElements(driver);
		(new WebDriverWait(driver.get(), 10)).until(ExpectedConditions.visibilityOf(object.name));

		object.SendValue(object.name, name);
		object.SendValue(object.phone, phone);
		object.SendValue(object.email, email);
		Select select = new Select(object.country);
		select.selectByVisibleText(country);
		object.SendValue(object.city, city);
		object.SendValue(object.username, username);
		object.SendValue(object.paswword, password);
		(new WebDriverWait(driver.get(), 10)).until(ExpectedConditions.elementToBeClickable(object.submit));

		object.ClickOnTheElement(object.submit);
		(new WebDriverWait(driver.get(), 10)).until(ExpectedConditions.visibilityOf(object.alert));

		assertEquals(object.GetTheTextOfTheElement(object.alert),
				"This is just a dummy form, you just clicked SUBMIT BUTTON");
	}

	@AfterTest
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(7000);
		if (driver.get() != null) {
			driver.get().quit();
		}
	}
}

