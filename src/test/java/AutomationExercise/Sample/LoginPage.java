package AutomationExercise.Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	

}
