package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public static final String searchFirstItemName = "Sleeves Printed Top - White";
	public static final String searchSecondItemName = "Half Sleeves Top Schiffli Detailing - Pink";

	WebDriver driver;
	WebDriverWait wait = null;
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

	@FindBy(xpath = "//div[@class='item active']//h1[1]")
	public WebElement homePage;

	@FindBy(xpath = "//h2[normalize-space()='Subscription']")
	public WebElement labelSubscription;

	@FindBy(id = "susbscribe_email")
	public WebElement setEmail;

	@FindBy(id = "subscribe")
	public WebElement subscribeButton;

	@FindBy(id = "success-subscribe")
	public WebElement labelSuccessSubscribe;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	public WebElement cartButton;

	@FindBy(xpath = "//div[@class='product-overlay']")
	public WebElement movetoItem;

	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]")
	public WebElement chooseFirstItem;

	@FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
	public WebElement viewProductButton;

	@FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
	public WebElement continueShoppingButton;

	@FindBy(id = "search_product")
	public WebElement searchBox;

	@FindBy(id = "submit_search")
	public WebElement searchButton;

	@FindBy(xpath = "//div[@class='overlay-content']//p[contains(text(),'Sleeves Printed Top - White')]")
	public WebElement searchItem;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	public WebElement getModal;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Continue")));
		continueButton.click();
		

	}

	public void clickDeleteAccountButton() {
		deleteAccountButton.click();

	}

	public String verifyAccountDeleteLabelDisplay() throws InterruptedException {
		return accountDeleteLabel.getText();

	}

	public String verifyHomePageisVisible() {
		return homePage.getText();

	}

	public String getLabelSubscription() {
		return labelSubscription.getText();

	}

	public void fillEmailAndClickArrowButton(String email) {
		setEmail.sendKeys(email);
		subscribeButton.click();

	}

	public String getlabelSuccessSubscribe() {
		return labelSuccessSubscribe.getText();
	}

	public void clickCartButton() {
		cartButton.click();
	}

	public void chooseFirstItem() {
		chooseFirstItem.click();
		

	}
	
	public void clickContinueShoppingButton() {
		continueShoppingButton.click();
	}

	public void clickSearchButtonforFirstItem() {
		searchBox.sendKeys(searchFirstItemName);
		searchButton.click();
		
	}
	public void clickSearchButtonforSecondItem() {
		searchBox.clear();
		searchBox.sendKeys(searchSecondItemName);
		searchButton.click();
		
	}

	public String getSearchItemName() {
		return searchItem.getText();
	}
}
