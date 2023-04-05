package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCartButton ;

	@FindBy(xpath="//input[@id='buy-now-button']")
	private WebElement buyNowButton ;
	
	WebDriver driver;
	
	//Variable Initialization
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	//Variable Use
	public void clickOnAddToCardButton () {
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,300)","clickOnAddToCardButton");
		//js.executeScript("arguments[0].scrollIntoView(true)",addToCartButton);
		addToCartButton.click();
	}
	
	public void clickONBuyNowButton () {
		buyNowButton.click();
	}
	
	
	
	
	
	
	
	
}


