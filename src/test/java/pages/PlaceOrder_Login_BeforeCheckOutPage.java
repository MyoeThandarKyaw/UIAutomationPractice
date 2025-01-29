package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder_Login_BeforeCheckOutPage {
	WebDriver driver;
	WebDriverWait wait = null;	
	
	@FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
	public WebElement proceedToCheckoutButton;

	@FindBy(name = "message")
	public WebElement messageBox;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	public WebElement placeOrderButton;
	
	@FindBy(name = "name_on_card")
	public WebElement nameOnCardBox;
	
	@FindBy(xpath = "//input[@name='card_number']")
	public WebElement cardNumberBox;

	@FindBy(name = "cvc")
	public WebElement cvcBox;
	
	@FindBy(name = "expiry_month")
	public WebElement expiryMonthBox;
	
	@FindBy(name = "expiry_year")
	public WebElement expiryYearBox;
	
	@FindBy(id = "submit")
	public WebElement submitButton;
	
	@FindBy(xpath = "//a[normalize-space()='Download Invoice']")
	public WebElement downloadInvoiceButton;
	
	public PlaceOrder_Login_BeforeCheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 55);
	}

	public void clickProceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}

	public void setMessage(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1050)", "");
		messageBox.sendKeys(message);
	}

	public void clickPlaceOrderButton() {
		placeOrderButton.click();
	}
	
	public void fillPaymentInformation(String nameOnCard, String cradNumber, String cvc, String expiryMonth, String expiryYear) {
		nameOnCardBox.sendKeys(nameOnCard);
		cardNumberBox.sendKeys(cradNumber);
		cvcBox.sendKeys(cvc);
		expiryMonthBox.sendKeys(expiryMonth);
		expiryYearBox.sendKeys(expiryYear);
		submitButton.click();
		downloadInvoiceButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Download Invoice']")));
	}

}
