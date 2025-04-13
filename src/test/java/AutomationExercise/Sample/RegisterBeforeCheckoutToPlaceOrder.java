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

public class RegisterBeforeCheckoutToPlaceOrder {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String userName = "Moe";
	public static final String userEmail = "Moe@gmail.com";
	public static final String expectedLoginUserName = "Moe";
	public static final String loginUserEmail = "Moe@gmail.com";
	public static final String loginPassword = "Moe@2024";
	public static final String expectedLabelName = "ENTER ACCOUNT INFORMATION";
	public static final String expectedLoginPageName = "Login to your account";
	public static final String expectedAccountCreatedLabelName = "ACCOUNT CREATED!";
	public static final String expectedAccountDeleteLabelName = "ACCOUNT DELETED!";
	public static final String orderMessage = "Pls take care order";
	public static final String nameOnCard = "Moe";
	public static final String cardNumber = "001734690079002347";
	public static final String cvc = "+95";
	public static final String expiryMonth = "12";
	public static final String expiryYear = "2027";

	HomePage homePage;
	LoginPage loginPage;
	VerifyProductQuantityinCartPage verifyProductQuantityinCartPage;
	PlaceOrder_Login_BeforeCheckOutPage placeOrder_Login_BeforeCheckOutPage;
	WebDriverWait wait = null;

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
	public void registerBeforeCheckoutToPlaceOrder() throws InterruptedException {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		verifyProductQuantityinCartPage = new VerifyProductQuantityinCartPage(driver);
		placeOrder_Login_BeforeCheckOutPage = new PlaceOrder_Login_BeforeCheckOutPage(driver);

		// Fill User Name and Email to register new account
		homePage.setUserNameAndEmail(userName, userEmail);

		// Verify label Name display
		String actualLabelName = homePage.verifyLabelDisplay();
		Assert.assertEquals(actualLabelName, expectedLabelName);

		// Fill all require information
		homePage.fillAllRequireInformation();
		String actualAccountCreatedLabelName = homePage.verifyAccountCreatedLabelDisplay();
		Assert.assertEquals(actualAccountCreatedLabelName, expectedAccountCreatedLabelName);

		// Click Continue Button
		homePage.clickContinueButton();

		// Verify Login Page is Visisble
//		String actualLoginPageName = loginPage.verifyLoginPageisVisisble();
//		Assert.assertEquals(actualLoginPageName, expectedLoginPageName);
//
//		loginPage.fillUserNameAndPassword(loginUserEmail, loginPassword);
//		loginPage.waitLoginUserName();

		//String actualLoginUserName = loginPage.verifyLoginNameisVisisble();
		//Assert.assertEquals(actualLoginUserName, expectedLoginUserName);

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
		placeOrder_Login_BeforeCheckOutPage.fillPaymentInformation(nameOnCard, cardNumber, cvc, expiryMonth,
				expiryYear);
	}

	@AfterMethod
	public void afterMethod() {
		// driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}
}
