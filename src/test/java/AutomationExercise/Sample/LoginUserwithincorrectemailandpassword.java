package AutomationExercise.Sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginUserwithincorrectemailandpassword{
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedLabelName = "Login to your account";
	public static final String expectedErrorMessage = "Your email or password is incorrect!";
	public static final String loginUserEmail = "MyoeThandar@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	
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
	public void loginUserwithcorrectEmailAndPassword() {
		loginPage=new LoginPage(driver);
		String actualLabelName=loginPage.verifyHomePageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.fillUserNameAndPassword(loginUserEmail,loginPassword );
		String actualErrorMessage=loginPage.getLoginErrorMessage();
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
