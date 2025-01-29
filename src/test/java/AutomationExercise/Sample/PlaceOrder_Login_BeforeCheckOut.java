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
import pages.HomePage;
import pages.LoginPage;
import pages.PlaceOrder_Login_BeforeCheckOutPage;
import pages.VerifyProductQuantityinCartPage;

public class PlaceOrder_Login_BeforeCheckOut {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedHomepageName = "AutomationExercise";
	public static final String expectedProductsLabel = "ALL PRODUCTS";
	public static final String expectedLoginUserName = "Myoe";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLabelName = "Login to your account";
	public static final String orderMessage = "Pls take care order";
	public static final String nameOnCard = "Myoe";
	public static final String cardNumber = "001734690079002347";
	public static final String cvc = "+95";
	public static final String expiryMonth = "12";
	public static final String expiryYear = "2027";


	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;
	VerifyProductQuantityinCartPage verifyProductQuantityinCartPage;
	PlaceOrder_Login_BeforeCheckOutPage placeOrder_Login_BeforeCheckOutPage;
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
		placeOrder_Login_BeforeCheckOutPage = new PlaceOrder_Login_BeforeCheckOutPage(driver);

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

		verifyProductQuantityinCartPage.clickViewCartButton();

		placeOrder_Login_BeforeCheckOutPage.clickProceedToCheckoutButton();
		placeOrder_Login_BeforeCheckOutPage.setMessage(orderMessage);
		placeOrder_Login_BeforeCheckOutPage.clickPlaceOrderButton();
		placeOrder_Login_BeforeCheckOutPage.fillPaymentInformation(nameOnCard, cardNumber, cvc, expiryMonth, actualLoginUserName);
	}

	@AfterMethod
	public void afterMethod() {
	 driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}
}
