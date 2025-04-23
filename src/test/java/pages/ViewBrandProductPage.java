package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewBrandProductPage {
	WebDriver driver;
	WebDriverWait wait = null;

	public ViewBrandProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);

	}
	@FindBy(xpath = "//h2[normalize-space()='Brands']")
	public WebElement brandName;
	
	@FindBy(xpath = "//a[@href='/brand_products/Kookie Kids']")
	public WebElement firstBrand;
	
	@FindBy(xpath = "//h2[normalize-space()='Brand - Kookie Kids Products']")
	public WebElement firstBrandName;
	
	@FindBy(xpath = "//a[@href='/brand_products/Madame']")
	public WebElement secondBrand;
	
	@FindBy(xpath = "//h2[normalize-space()='Brand - Madame Products']")
	public WebElement secondBrandName;

	public String getBrandNameLabel() {
		return brandName.getText();
	}
	public void clickFirstBrand() {
		firstBrand.click();
	}
	public String getFirstBrandName() {
		return firstBrandName.getText();
	}
	public void clickSecondBrand() {
		secondBrand.click();
	}
	public String getSecondBrandName() {
		return secondBrandName.getText();
	}
}
