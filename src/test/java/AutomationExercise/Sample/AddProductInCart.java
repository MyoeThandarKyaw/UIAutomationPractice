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

public class AddProductInCart {
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
	int itemNumber=0;

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
	public void addProdcutInCart() {
		//loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

		loginPage=new LoginPage(driver);
		String actualLabelName=loginPage.verifyLoginPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.fillUserNameAndPassword(loginUserEmail,loginPassword );
		loginPage.waitLoginUserName();	
		
		String actualLoginUserName=loginPage.verifyLoginNameisVisisble();
		Assert.assertEquals(actualLoginUserName, expectedLoginUserName);

		loginPage.clickProductLinkButton();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i=1; i<=2;i++) {
		itemNumber=i;
		switch(itemNumber) {
		case 1 :
			homePage.clickSearchButtonforFirstItem();
			js.executeScript("window.scrollBy(0,1050)", "");
			break;
			
		case 2 :
			homePage.clickSearchButtonforSecondItem();
			js.executeScript("window.scrollBy(0,750)", "");			
			break;			
		}
			
		homePage.chooseFirstItem();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		homePage.clickContinueShoppingButton();
		
		}
		
	}

	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}
}
