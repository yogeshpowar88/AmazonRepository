package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	// Declaration
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement selectMobileName ;

	// Initialization
		public SearchResultPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
	// Use
		public void clickOnMobileName () {
			selectMobileName.click();	
		}
		
		
		
		
		//  (//div//h2//a//span[@class='a-size-medium a-color-base a-text-normal'])[1]
		
		
		
		
		
}
