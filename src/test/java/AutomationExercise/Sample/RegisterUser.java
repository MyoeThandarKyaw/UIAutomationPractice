package AutomationExercise.Sample;
import pages.HomePage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class RegisterUser {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String userName = "Myoe";
	public static final String userEmail = "Myoe@gmail.com";
	public static final String expectedLabelName = "ENTER ACCOUNT INFORMATION";
	public static final String expectedAccountCreatedLabelName = "ACCOUNT CREATED!";
	public static final String expectedAccountDeleteLabelName = "ACCOUNT DELETED!";
	
	HomePage homePage;
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
	public void registerUser() throws InterruptedException {
		homePage=new HomePage(driver);
		homePage.setUserNameAndEmail(userName,userEmail);
		String actualLabelName=homePage.verifyLabelDisplay();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		homePage.fillAllRequireInformation();
		String actualAccountCreatedLabelName=homePage.verifyAccountCreatedLabelDisplay();
		Assert.assertEquals(actualAccountCreatedLabelName, expectedAccountCreatedLabelName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Continue")));
		homePage.clickContinueButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Delete Account']")));
		homePage.clickDeleteAccountButton();
		String actualAccountDeleteLabelName=homePage.verifyAccountDeleteLabelDisplay();
		Assert.assertEquals(actualAccountDeleteLabelName, expectedAccountDeleteLabelName);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
