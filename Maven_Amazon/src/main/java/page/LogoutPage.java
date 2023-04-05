package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	// Declaration
		@FindBy (xpath = "//span[text()='Sign Out']")
		private WebElement logOutLink ;
		
		WebDriver driver;
		// Initialization
		public LogoutPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
		// use
		public void clickOnLogOut() {
			Actions act = new Actions(driver);
			act.moveToElement(logOutLink);
			logOutLink.click();
			
		}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
