package testNgpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browserSetup.Base;
import page.HomePage;
import page.LoginPage;
import page.PasswordPage;
import page.ProductDetailsPage;
import page.SearchResultPage;
import utils.Utility;

public class TestAddToCart extends Base {
	

	WebDriver driver;
	HomePage homePage;
	LoginPage loginpage;
	PasswordPage passwordPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	String testID;
	
	@Parameters("browser")
	
	
	@BeforeTest
	public void launchBrowser(String browser)
	{
		System.out.println("Before Test");
		if(browser.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();
		}
		
		if(browser.equals("Edge"))
		{
			driver = Base.openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	
	@BeforeClass
	public void beforeClass ()
	{
		System.out.println("Before Class");
		homePage = new HomePage (driver);
		loginpage = new LoginPage(driver);
		passwordPage = new PasswordPage(driver);
		searchResultPage = new SearchResultPage (driver);
		productDetailsPage = new ProductDetailsPage (driver);
	}
	
	
	@BeforeMethod
	public void beforeMethod () throws InterruptedException 
	{
		System.out.println("Before Method");
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		homePage.clickOnSignIn();
		loginpage.sendemaiormobile();
		loginpage.clickoncontinuebtn();
		passwordPage.sendpassword();
		passwordPage.clickOnSignIn();
		
		
	}
	
	
	@Test
	public void verifyAddToCartFunctionality ()
	{
		testID = "TC01";
		System.out.println("Test1");
		homePage.enterTextIntoSearchbox("Mobiles");
		homePage.clickOnSearchButton();
		searchResultPage.clickOnMobileName();
		productDetailsPage.clickOnAddToCardButton();

		
		
		
	}
	
	
	@AfterMethod
	public void afterMethod (ITestResult result) 
	{
		System.out.println("After Method");
		if(ITestResult.FAILURE==result.getStatus()) {
		try {
			Utility.FailedTestCasesTakeScreenshot(driver, testID);
			System.out.println("Screenshot Taken");
		}
		catch (Exception e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());		}
		homePage.clickOnLogOut();
	}
	}
	
	@AfterClass
	public void afterClass ()
	{
		System.out.println("After Class");
		
		homePage = null;
	}
	
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		driver = null;

	}
	
	

}
