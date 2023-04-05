package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Variable Declaration
		@FindBy (xpath = "//input[@id=\"twotabsearchtextbox\"]")
		private WebElement searchTextbox ;
		
		@FindBy (xpath = "//input[@id='nav-search-submit-button']")
		private WebElement searchButton ;
		
		@FindBy (xpath = "//select[@aria-describedby='searchDropdownDescription']")
		private WebElement searchDropdown ;
		
		@FindBy (xpath = "//a[@id='nav-global-location-popover-link']")
		private WebElement selectYourLocation ;

		@FindBy (xpath = "//span[@class='icp-nav-link-inner']")
		private WebElement selectLanguage ;
		
		@FindBy (xpath = "//span[text()='Account & Lists']")
		private WebElement accountAndListDropdown ;
		
		@FindBy (xpath = "(//span[text()='Sign in'])[1]")
		private WebElement signInLink ;
		
		@FindBy (xpath = "//span[text()='Sign Out']")
		private WebElement logOutLink ;
		
		WebDriver driver;
		Actions act ; 
		//Variable Initialization
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver ;
			act = new Actions(driver);
		}
		
		//Variable Use
		public void clickOnaccountAndListDropdown () {
			accountAndListDropdown.click();
		}
		
		public void enterTextIntoSearchbox (String searchtext) {
			searchTextbox.sendKeys(searchtext);
			//return searchtext;		
		}
		
		public void clickOnSearchButton () {
			searchButton.click();
		}
		
		public void clickOnLogOut() {
			act.moveToElement(accountAndListDropdown).moveToElement(logOutLink).click().build().perform();
			//logOutLink.click();	
		}
		
		public void clickOnSignIn() {
			act.moveToElement(accountAndListDropdown).build().perform();
			signInLink.click();	
		}
		
		
		
		
		
		
		
		
		
		
}




