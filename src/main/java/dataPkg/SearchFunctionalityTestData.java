package dataPkg;

import org.testng.annotations.DataProvider;

import mainPkg.Base;

public class SearchFunctionalityTestData extends Base{
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] searchProduct = {"apple","orange","samsung"};
		return searchProduct;
	}

}
