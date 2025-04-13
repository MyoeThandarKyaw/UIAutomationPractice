package AutomationExercise.Sample;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.RemoveProductFromCardPage;
import pages.VerifyProductQuantityinCartPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RemoveProductfromCard {
	WebDriver driver;
	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedLoginUserName = "Myoe";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLabelName = "Login to your account";
	public static final String expectedErrorMessage = "Cart is empty! Click here to buy products.";
	
	VerifyProductQuantityinCartPage verifyProductQuantityinCartPage;
	RemoveProductFromCardPage removeProductfromCardPage;

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
	public void removeProductfromCard() {
		homePage = new HomePage(driver);

		loginPage = new LoginPage(driver);
		verifyProductQuantityinCartPage = new VerifyProductQuantityinCartPage(driver);
		removeProductfromCardPage = new RemoveProductFromCardPage(driver);

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
		removeProductfromCardPage.clickDeleteProductButton();
		
		//Verify Product Cart is Empty
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empty_cart")));		
		String actualEmptyMessage =removeProductfromCardPage.getEmptyMessage();
		Assert.assertEquals(actualEmptyMessage, expectedErrorMessage);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
