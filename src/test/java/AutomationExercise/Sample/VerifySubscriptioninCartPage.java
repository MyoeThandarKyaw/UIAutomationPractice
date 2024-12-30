package AutomationExercise.Sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifySubscriptioninCartPage {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/";
	public static final String expectedLabelName = "SUBSCRIPTION";
	public static final String expectedHomepageName = "AutomationExercise";
	public static final String email = "Myoe@gmail.com";
	public static final String expectedSuccessLabel = "You have been successfully subscribed!";

	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;

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
	public void verifySubscriptioninCartPage() {
		homePage = new HomePage(driver);
		String actualHomePageName = homePage.verifyHomePageisVisible();
		Assert.assertEquals(actualHomePageName, expectedHomepageName);

		// Click Cart Button
		homePage.clickCartButton();

		// Scroll down to footer
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		String actualLabelName = homePage.getLabelSubscription();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		homePage.fillEmailAndClickArrowButton(email);

		String actualSuccessLabel = homePage.getlabelSuccessSubscribe();
		Assert.assertEquals(actualSuccessLabel, expectedSuccessLabel);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}
}
