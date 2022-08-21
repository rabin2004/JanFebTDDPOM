package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mainPkg.Base;

public class SearchResultPage extends Base{

	@FindBy(xpath="//span[@class=\"a-color-state a-text-bold\"]")
	WebElement searchResultTxt;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String returnSearchResultTxt() {
		String product = searchResultTxt.getText();
		product = product.substring(1,product.length()-1);
		return product;
	}
	
	public String returnSearchResultPageTitle() {
		return driver.getTitle();
	}
	
	public String returnSearchResultPageUrl() {
		return driver.getCurrentUrl();
	}
}
