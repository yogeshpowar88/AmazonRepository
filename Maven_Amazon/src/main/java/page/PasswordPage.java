package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	
	//Variable Declaration
		@FindBy (xpath = "//input[@type='password']")
		private WebElement password ;
		
		@FindBy (xpath = "//span[@id='auth-signin-button']")
		private WebElement signInButton ;

		@FindBy (xpath = "//a[@id='auth-fpp-link-bottom']")
		private WebElement forgetPasswordLink ;
		
		@FindBy (xpath = "//span[text()='+917083725023']")
		private WebElement checkNumber ;
		
		@FindBy (xpath = "//a[@id='ap_change_login_claim']")
		private WebElement changeLink ;
		
		@FindBy (xpath = "//span[@id='auth-login-via-otp-btn-announce']")
		private WebElement getOtpButton ;
		
		//Variable Initialization
		public PasswordPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Variable Use
		public void sendpassword () {
			password.sendKeys("7083725023");
		}
		
		public void clickOnSignIn () {
			signInButton.click();		}
		
		
		
}



