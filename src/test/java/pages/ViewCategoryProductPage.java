package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCategoryProductPage {
	WebDriver driver;
	WebDriverWait wait = null;

	public ViewCategoryProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 25);

	}

	@FindBy(xpath = "//h2[normalize-space()='Category']")
	public WebElement categoryLabel;
	
	@FindBy(xpath = "//a[normalize-space()='Women']")
	public WebElement womemCategory;
	
	@FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
	public WebElement womenSubCategory;
	
	@FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
	public static WebElement womenProductList;
	
	@FindBy(xpath = "//a[normalize-space()='Men']")
	public WebElement menCategory;
	
	@FindBy(xpath = "//a[normalize-space()='Tshirts']")
	public WebElement menSubCategory;
	
	@FindBy(xpath = "//h2[normalize-space()='Men - Tshirts Products']")
	public WebElement menProductList;

	public String getCategoryLabel() {
		return categoryLabel.getText();
	}
	public void clickWomenCategory() {
		womemCategory.click();
		womenSubCategory.click();
	}
	public String getWomenProductList() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Women - Dress Products']")));	
		return womenProductList.getText();
	}
	public void clickMenCategory() {
		menCategory.click();
		menSubCategory.click();
	}
	
	public String getMenProductList() {	
		return menProductList.getText();
	}
}
