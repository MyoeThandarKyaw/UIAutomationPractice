package AutomationExercise.Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	public static final String first_Name = "Myoe Thandar";
	public static final String last_Name = "Kyaw";
	public static final String postal_Code = "+95";
	public static final String company = "WaveMoney";
	public static final String address1 = "No-4, 6B, Marlar Myaing 7 St";
	public static final String address2 = "No-4, 6B, Marlar Myaing 7 St";
	public static final String state = "Yangon";
	public static final String city = "Yangon";
	public static final String userPassword = "Myoe@2024";
	public static final String zipCode = "+95";
	public static final String mobileNumber = "9791009103";
	WebDriver driver;

	@FindBy(name = "name")
	public WebElement userName;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement userEmail;

	@FindBy(xpath = "//button[normalize-space()='Signup']")
	public WebElement signupButton;

	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	public WebElement accountInformation;

	@FindBy(id = "id_gender2")
	public WebElement mrsRadioButton;

	@FindBy(id = "password")
	public WebElement setUserPassword;

	@FindBy(id = "days")
	public WebElement daysOption;

	@FindBy(id = "months")
	public WebElement monthsOption;

	@FindBy(id = "years")
	public WebElement yearsOption;

	@FindBy(id = "newsletter")
	public WebElement newsletterCheckBox;

	@FindBy(id = "optin")
	public WebElement optinCheckBox;

	@FindBy(id = "first_name")
	public WebElement setFirstName;

	@FindBy(id = "last_name")
	public WebElement setLastName;

	@FindBy(id = "company")
	public WebElement setCompany;

	@FindBy(id = "address1")
	public WebElement setAddress1;

	@FindBy(id = "address2")
	public WebElement setAddress2;

	@FindBy(id = "country")
	public WebElement chooseCountry;

	@FindBy(id = "state")
	public WebElement setState;

	@FindBy(id = "city")
	public WebElement setCity;

	@FindBy(id = "zipcode")
	public WebElement setZipCode;

	@FindBy(id = "mobile_number")
	public WebElement setMobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	public WebElement submitRegistration;

	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	public WebElement accountCreateLabel;

	@FindBy(linkText = "Continue")
	public WebElement continueButton;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	public WebElement deleteAccountButton;
	
	@FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
	public WebElement accountDeleteLabel;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserNameAndEmail(String name, String email) {
		userName.sendKeys(name);
		userEmail.sendKeys(email);
		signupButton.click();

	}

	public String verifyLabelDisplay() throws InterruptedException {
		return accountInformation.getText();

	}

	public void fillAllRequireInformation() throws InterruptedException {
		mrsRadioButton.click();
		setUserPassword.sendKeys(userPassword);
		Select chooseDays = new Select(daysOption);
		chooseDays.selectByValue("4");
		Select chooseMonths = new Select(monthsOption);
		chooseMonths.selectByValue("4");
		Select chooseYear = new Select(yearsOption);
		chooseYear.selectByValue("2020");
		newsletterCheckBox.click();
		optinCheckBox.click();
		setFirstName.sendKeys(first_Name);
		setLastName.sendKeys(last_Name);
		setCompany.sendKeys(company);
		setAddress1.sendKeys(address1);
		setAddress2.sendKeys(address2);
		Select choiceCountry = new Select(chooseCountry);
		choiceCountry.selectByValue("United States");
		setState.sendKeys(state);
		setCity.sendKeys(city);
		setZipCode.sendKeys(zipCode);
		setMobileNumber.sendKeys(mobileNumber);
		submitRegistration.click();

	}

	public String verifyAccountCreatedLabelDisplay() throws InterruptedException {
		return accountCreateLabel.getText();

	}

	public void clickContinueButton() {
		continueButton.click();
		// deleteAccountButton.click();

	}

	public void clickDeleteAccountButton() {
		deleteAccountButton.click();

	}
	public String verifyAccountDeleteLabelDisplay() throws InterruptedException {
		return accountDeleteLabel.getText();

	}
}
