package AutomationExercise.Sample;

import org.testng.annotations.Test;

import pages.LoginPage;

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

public class ContactUsForm {
	WebDriver driver;
	public static final String URL = "https://automationexercise.com/login";
	public static final String expectedLabelName = "Login to your account";
	public static final String expectedMessage = "GET IN TOUCH";
	public static final String loginUserEmail = "Myoe@gmail.com";
	public static final String loginPassword = "Myoe@2024";
	public static final String expectedLoginUserName = "Myoe";
	public static final String studentName = "Myoe Thandar Kyaw";
	public static final String email = "myoethandarkyaw@gmail.com";
	public static final String subject = "ICT";
	public static final String message = "scholarship is not just an investment in my future";

	
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
	public void contactUsForm() throws AWTException {
		loginPage=new LoginPage(driver);
		String actualLabelName=loginPage.verifyLoginPageisVisisble();
		Assert.assertEquals(actualLabelName, expectedLabelName);
		loginPage.clickContactUsButton();
		
		String actualMessage=loginPage.verifyContactUsPageisVisisble();
		Assert.assertEquals(actualMessage, expectedMessage);
		loginPage.fillAllContactInformation(studentName, email,subject,message);
		
		loginPage.fileUploadAndSubmit();
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
