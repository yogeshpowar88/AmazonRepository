package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Variable Declaration
	@FindBy (xpath = "//input[@type='email']")
	private WebElement emailOrMobilenum ;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continButton ;
	
	@FindBy (xpath = "//span[@class='a-expander-prompt']")
	private WebElement needhelptab ;
	
	@FindBy (xpath = "//a[@id='auth-fpp-link-bottom']")
	private WebElement forgetPassLink ;
	
	@FindBy (xpath = "//a[@id='createAccountSubmit']")
	private WebElement createAccButton ;
	
	@FindBy (xpath = "(//a[@class='a-link-normal'])[3]")
	private WebElement otherIssuLink ;
	
	//Variable Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Variable use
	public void sendemaiormobile() {
		emailOrMobilenum.sendKeys("917083725023");
	}
	
	public void clickoncontinuebtn() {
		continButton.click();
		
	}
	
	public String getTextOnCreateNewAccButton() {
		String s = createAccButton.getText();
		return s;
		
	}
	
	
	
	
	
	
	
	
	
	
}




