package AutomationExercise.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.VerifyProductQuantityinCartPage;

public class VerifyProductQuantityinCart {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedHomepageName = "AutomationExercise";
	public static final String expectedProductsLabel = "ALL PRODUCTS";
	public static final String expectedLoginUserName = "Myoe";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLabelName = "Login to your account";

	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;
	VerifyProductQuantityinCartPage verifyProductQuantityinCartPage;
	int expectedQuantity = 4;

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
	public void verifyProductQuantityinCart() {
		// loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		loginPage = new LoginPage(driver);
		verifyProductQuantityinCartPage = new VerifyProductQuantityinCartPage(driver);

		String actualLabelName = loginPage.verifyLoginPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.fillUserNameAndPassword(loginUserEmail, loginPassword);
		loginPage.waitLoginUserName();

		String actualLoginUserName = loginPage.verifyLoginNameisVisisble();
		Assert.assertEquals(actualLoginUserName, expectedLoginUserName);

		loginPage.clickProductLinkButton();
		homePage.clickSearchButtonforFirstItem();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1050)", "");
		verifyProductQuantityinCartPage.clickViewProductButton();
		verifyProductQuantityinCartPage.setQuantity();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		verifyProductQuantityinCartPage.clickViewCartButton();
		int quantity = Integer.valueOf(verifyProductQuantityinCartPage.getQuantity());
		Assert.assertEquals(quantity, expectedQuantity);
	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}
}
