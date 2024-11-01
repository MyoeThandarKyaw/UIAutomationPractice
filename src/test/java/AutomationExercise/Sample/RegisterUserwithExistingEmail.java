package AutomationExercise.Sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RegisterUserwithExistingEmail {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/";
	public static final String expectedLabelName = "New User Signup!";
	public static final String expectedHomepageName = "AutomationExercise";
	public static final String signUpUserEmail = "Myoe@gmail.com";
	public static final String signUpUserName = "Myoe";
	public static final String expectedErrorMessage = "Email Address already exist!";

	
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
	public void contactUsForm() throws AWTException {
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		String actualHomePageName=loginPage.verifyHomePageisVisible();
		Assert.assertEquals(actualHomePageName, expectedHomepageName);
	
		loginPage.clickSignup_LoginButton();
		String actualLabelName=loginPage.verifyNewUserSignUpPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		homePage.setUserNameAndEmail(signUpUserName,signUpUserEmail);
		String actualErrorMessage=loginPage.verifyHomePageisVisible();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
