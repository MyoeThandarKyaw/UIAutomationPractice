package AutomationExercise.Sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	
	WebDriver driver;
	WebDriverWait wait = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);

	}

	public String verifyHomePageisVisisble() {
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
	public void fileUploadAndSubmit() throws AWTException{	
		chooseFile.sendKeys("D:\\Testing Information\\TEST DATA\\testImage.jpg");
		submitButton.click();
	}
}
