package dataPkg;

import org.testng.annotations.DataProvider;

import mainPkg.Base;

public class SearchFunctionalityTestData extends Base{
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] searchProduct = {"apple","orange","samsung"};
		return searchProduct;
	}
	
	@DataProvider
	public String[] negativeSearchData() {
		String[] searchProduct = {"OGIYFIYFIGUG@*^(^*(^^(*@$Y98696498216489241","OGIYFIYFIGUG@*^(^*(^^(*@$Y98696498216489241^&%&^%&^"};
		return searchProduct;
	}

}
