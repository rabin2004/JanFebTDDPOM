package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainPkg.Base;

public class HomePage extends Base{
	
	// 1. Create webElement -> @FindBy
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTxtField;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	// 2. Initialize elements driver -> in constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// 3. Actions to be performed on element -> separate method
	public void enterProductOnSerachField(String product) {
		searchTxtField.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public String returnHomePageTitle() {
		return driver.getTitle();
	}
	
	public String returnHomePageUrl() {
		return driver.getCurrentUrl();
	}

}
