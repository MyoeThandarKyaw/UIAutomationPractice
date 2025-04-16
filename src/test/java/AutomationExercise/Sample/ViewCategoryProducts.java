package AutomationExercise.Sample;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ViewCategoryProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class ViewCategoryProducts {
	WebDriver driver;
	WebDriverWait wait = null;
	LoginPage loginPage;
	HomePage homePage;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedLoginUserName = "Myoe";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLabelName = "Login to your account";
	public static final String expectedCategoryname = "CATEGORY";
	public static final String expectedWomenProductListName = "WOMEN - DRESS PRODUCTS";
	public static final String expectedMenProductListName = "MEN - TSHIRTS PRODUCTS";

	ViewCategoryProductPage viewCategoryProductPage;

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
		homePage = new HomePage(driver);

		loginPage = new LoginPage(driver);
		viewCategoryProductPage = new ViewCategoryProductPage(driver);

		String actualLabelName = loginPage.verifyLoginPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.fillUserNameAndPassword(loginUserEmail, loginPassword);
		loginPage.waitLoginUserName();

		//Verify login username
		String actualLoginUserName = loginPage.verifyLoginNameisVisisble();
		Assert.assertEquals(actualLoginUserName, expectedLoginUserName);

		// Verify Category label display
		String actualCategoryName = viewCategoryProductPage.getCategoryLabel();
		Assert.assertEquals(actualCategoryName, expectedCategoryname);
		viewCategoryProductPage.clickWomenCategory();

		// Verify Women Product List display
		String actualProductListName = viewCategoryProductPage.getWomenProductList();
		Assert.assertEquals(actualProductListName, expectedWomenProductListName);

		// Click Men Category
		viewCategoryProductPage.clickMenCategory();

		// Verify Men Category label display
		String actualMenCategoryName = viewCategoryProductPage.getMenProductList();
		Assert.assertEquals(actualMenCategoryName, expectedMenProductListName);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
