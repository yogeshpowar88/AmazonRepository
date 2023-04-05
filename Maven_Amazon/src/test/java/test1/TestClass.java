package test1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.HomePage;
import page.LoginPage;
import page.PasswordPage;
import page.ProductDetailsPage;
import page.SearchResultPage;

public class TestClass {
	
	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver" , "C:\\Selenium setup\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver ();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		HomePage homePage = new HomePage (driver);
		homePage.clickOnaccountAndListDropdown();
		Thread.sleep(2000);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.sendemaiormobile();
		loginpage.clickoncontinuebtn();
		
		Thread.sleep(2000);
		PasswordPage passwordPage = new PasswordPage(driver);
		passwordPage.sendpassword();
		passwordPage.clickOnSignIn();
		
		Thread.sleep(2000);
		homePage.enterTextIntoSearchbox();
		homePage.clickOnSearchButton();
		
		Thread.sleep(2000);
		SearchResultPage searchResultPage = new SearchResultPage (driver);
		searchResultPage.clickOnMobileName();
		
		Thread.sleep(2000);
		ArrayList<String> add = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		ProductDetailsPage productDetailsPage = new ProductDetailsPage (driver);
		productDetailsPage.clickOnAddToCardButton();
		//productDetailsPage.clickONBuyNowButton();
	}

}
