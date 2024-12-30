package AutomationExercise.Sample;
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(xpath = "//h2[normalize-space()='Login to your account']")
	public WebElement loginToYourAccount;

	@FindBy(xpath = "//b[normalize-space()='Myoe']")
	public WebElement loginUserName;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	public WebElement loginEmailTextBox;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement loginPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
	public WebElement loginErrorMessage;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement logoutButton;

	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	public WebElement contactUsButton;

	@FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
	public WebElement getInTouchMessage;

	@FindBy(xpath = "//input[@placeholder='Name']")
	public WebElement contactName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement contactEmail;

	@FindBy(xpath = "//input[@placeholder='Subject']")
	public WebElement contactSubject;

	@FindBy(xpath = "//textarea[@id='message']")
	public WebElement contactMessage;

	@FindBy(xpath = "//input[@name='upload_file']")
	public WebElement chooseFile;

	@FindBy(xpath = "//input[@name='submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
	public WebElement newUserSignUp;
	
	@FindBy(xpath = "//div[@class='item active']//h1[1]")
	public WebElement homePage;
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	public WebElement signUpLoginButton;
	
	@FindBy(name = "name")
	public WebElement userName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement userEmail;
	
	@FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
	public WebElement emailAlreadyExistErrorMessage;

	@FindBy(xpath = "//a[normalize-space()='Test Cases']")
	public WebElement testCasesPage;
	
	@FindBy(xpath = "//b[normalize-space()='Test Cases']")
	public WebElement testCasesLabel;
	
	@FindBy(xpath = "//a[@href='/products']")
	public WebElement productLink;
	
	@FindBy(xpath = "//h2[normalize-space()='All Products']")
	public WebElement allProductsLabel;
	
	WebDriver driver;
	WebDriverWait wait = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);

	}

	public String verifyLoginPageisVisisble() {
		return loginToYourAccount.getText();

	}

	public String verifyLoginNameisVisisble() {
		return loginUserName.getText();

	}

	public void fillUserNameAndPassword(String loginUserEmail, String password) {
		loginEmailTextBox.sendKeys(loginUserEmail);
		loginPassword.sendKeys(password);
		loginButton.click();
	}

	public String getLoginErrorMessage() {
		return loginErrorMessage.getText();

	}

	public void waitLoginUserName() {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginUserName)));
	}

	public void clickLogoutButton() {
		logoutButton.click();
	}

	public void clickContactUsButton() {
		contactUsButton.click();
	}

	public String verifyContactUsPageisVisisble() {
		return getInTouchMessage.getText();

	}

	public void fillAllContactInformation(String name, String email, String subject, String message) {
		contactName.sendKeys(name);
		contactEmail.sendKeys(email);
		contactSubject.sendKeys(subject);
		contactMessage.sendKeys(message);

	}

	public void fileUploadAndSubmit() throws AWTException {
		chooseFile.sendKeys("D:\\Testing Information\\TEST DATA\\testImage.jpg");
		submitButton.click();
	}
	
	public String verifyNewUserSignUpPageisVisisble() {
		return newUserSignUp.getText();

	}
	
	public String verifyHomePageisVisible() {
		return homePage.getText();

	}
	public void clickSignup_LoginButton() {
		signUpLoginButton.click();
	}
	public String getEmailAlreadyExistErrorMessage() {
		return emailAlreadyExistErrorMessage.getText();

	}
	public void clickTestCasesButton() {
		testCasesPage.click();
	}
	public String verifyTestCasesPageisVisible() {
		return testCasesLabel.getText();

	}
	
	public void clickProductLinkButton() {
		productLink.click();
	}
	
	public String getAllProductsLabel() {
		return allProductsLabel.getText();

	}
	
}
