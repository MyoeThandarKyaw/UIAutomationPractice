package AutomationExercise.Sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class VerifyAllProductsandProductDetailPage {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/";
	public static final String expectedHomepageName = "AutomationExercise";
	public static final String expectedProductsLabel = "ALL PRODUCTS";

	WebDriverWait wait = null;
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		// Maximize the browser
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 25);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(URL);
	}

	@Test
	public void verifyAllProductsandProductDetailPage() {
		loginPage = new LoginPage(driver);
		String actualHomePageName = loginPage.verifyHomePageisVisible();
		Assert.assertEquals(actualHomePageName, expectedHomepageName);
		loginPage.clickProductLinkButton();
		String actualProductLabel = loginPage.getAllProductsLabel();
		Assert.assertEquals(actualProductLabel, expectedProductsLabel);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
