package testPkg;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mainPkg.Base;
import pageFactory.HomePage;
import pageFactory.SearchResultPage;

public class SearchFunctionalityTest extends Base{
	HomePage hp;
	SearchResultPage srp;
	
	@BeforeMethod
	public void loadBrowser() {
		intitialization();
		hp = new HomePage();
		srp = new SearchResultPage();
	}
	
	@AfterMethod
	public void closeBroswer() {
		tearDown();
	}
	
	@Test(dataProviderClass = dataPkg.SearchFunctionalityTestData.class, 
			dataProvider="positiveSearchData")
	public void postiveSearchFuntionalityTest(String product) {
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
		hp.enterProductOnSerachField(product);
//		driver.findElement(By.id("nav-search-submit-button")).click();
		hp.clickSearchBtn();
//		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com : "+product;
		// Assertion -> creating validation point
		Assert.assertEquals(srp.returnSearchResultPageTitle(), expectedTitle);
		Assert.assertTrue(srp.returnSearchResultPageUrl().contains(product));
		Assert.assertFalse(!srp.returnSearchResultPageTitle().contains(product));
	}

}
