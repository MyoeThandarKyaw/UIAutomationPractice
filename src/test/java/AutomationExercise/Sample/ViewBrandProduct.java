package AutomationExercise.Sample;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ViewBrandProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ViewBrandProduct {
	WebDriver driver;
	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedLoginUserName = "Myoe";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLabelName = "Login to your account";
	public static final String expectedBrandLabel = "BRANDS";
	public static final String expectedFirstBrandName = "BRAND - KOOKIE KIDS PRODUCTS";
	public static final String expectedSecondBrandName = "BRAND - MADAME PRODUCTS";

	// ViewCategoryProductPage viewCategoryProductPage;
	ViewBrandProductPage viewBrandProductPage;

	@BeforeMethod
	public void beforeMethod() {
		driver.get(URL);
	}

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

	@Test
	public void viewCategoryProducts() {

		loginPage = new LoginPage(driver);
		viewBrandProductPage = new ViewBrandProductPage(driver);

		String actualLabelName = loginPage.verifyLoginPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.fillUserNameAndPassword(loginUserEmail, loginPassword);
		loginPage.waitLoginUserName();

		// Verify login username
		String actualLoginUserName = loginPage.verifyLoginNameisVisisble();
		Assert.assertEquals(actualLoginUserName, expectedLoginUserName);

		loginPage.clickProductLinkButton();

		// Verify Brand label display
		String actualBrandLabel = viewBrandProductPage.getBrandNameLabel();
		Assert.assertEquals(actualBrandLabel, expectedBrandLabel);
		viewBrandProductPage.clickFirstBrand();

		// Verify First Brand display
		String actualFirstBrandName = viewBrandProductPage.getFirstBrandName();
		Assert.assertEquals(actualFirstBrandName, expectedFirstBrandName);
		viewBrandProductPage.clickSecondBrand();

		// Verify First Brand display
		String actualSecondBrandName = viewBrandProductPage.getSecondBrandName();
		Assert.assertEquals(actualSecondBrandName, expectedSecondBrandName);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
