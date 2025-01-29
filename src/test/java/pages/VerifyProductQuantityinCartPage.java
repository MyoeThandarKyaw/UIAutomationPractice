package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VerifyProductQuantityinCartPage {
	WebDriver driver;
	WebDriverWait wait = null;	
	
	@FindBy(xpath = "(//a[normalize-space()='View Product'])[1]")
	public WebElement viewProductButton;
	
	@FindBy(id = "quantity")
	public WebElement quantityBox;
	
	@FindBy(xpath = "//button[normalize-space()='Add to cart']")
	public WebElement addToCartButton;
	
	@FindBy(xpath = "//u[normalize-space()='View Cart']")
	public WebElement viewCart;
	
	@FindBy(xpath = "//button[normalize-space()='4']")
	public WebElement getQuantity;
	
	public VerifyProductQuantityinCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);
	}
	
	public void clickViewProductButton() {
		viewProductButton.click();
	}
	
	public void setQuantity() {
		quantityBox.clear();
		quantityBox.sendKeys("4");
		addToCartButton.click();
		
	}
	public void clickViewCartButton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));
		viewCart.click();		
	}
	
	public String getQuantity() {
		String quantity=getQuantity.getText();
		return quantity;
	}
	
}
