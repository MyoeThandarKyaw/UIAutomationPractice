package AutomationExercise.Sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SearchGoogle {
	WebDriver driver;
	public static final String URL = "https://www.google.com/";
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
	public void testGoogleSearch() {
		        // find the search edit box on the google page
				WebElement p = driver.findElement(By.name("q"));

				// enter text with sendKeys() then apply submit()
				p.sendKeys("Appium");
				p.sendKeys(Keys.ENTER);

				driver.findElement(By.xpath("//a[@href='http://appium.io/']")).click();
				// get text from appium website
				String actualString = driver.findElement(By.className("md-content")).getText();
				System.out.println("actualString ===" + actualString + "===end===");

				// Check actual result and expected result
				Assert.assertTrue(actualString.contains("Welcome to the Appium documentation!"));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
