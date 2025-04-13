package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveProductFromCardPage {
	WebDriver driver;
	WebDriverWait wait = null;

	public RemoveProductFromCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);

	}

	@FindBy(xpath = "(//a[@class='cart_quantity_delete'])[1]")
	public WebElement deletProductButton;
	
	@FindBy(xpath = "(//p[contains(text(),'Click')])[1]")
	public WebElement emptyProductMessage;

	public void clickDeleteProductButton() {
		deletProductButton.click();
	}
	public String getEmptyMessage(){
		return emptyProductMessage.getText();
	}
}
