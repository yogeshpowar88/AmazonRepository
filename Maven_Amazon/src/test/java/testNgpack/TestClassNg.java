package testNgpack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import browserSetup.Base;
import page.HomePage;
import page.LoginPage;
import page.PasswordPage;
import utils.Utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;


public class TestClassNg extends Base {
	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginpage;
	PasswordPage passwordPage;
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
		
	}
	
	@BeforeMethod
	public void beforeMethod (String browser) throws InterruptedException 
	{
		System.out.println("Before Method");
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		homePage.clickOnSignIn();
	}
	
//	@Test 
//	public void verifyLoginPage() 
//	{
//		testID = "Test-TC01";
//		System.out.println("Test2");
//		loginpage.sendemaiormobile();
//		loginpage.clickoncontinuebtn();
//		
//		passwordPage.sendpassword();
//		passwordPage.clickOnSignIn();
//			
//		homePage.enterTextIntoSearchbox();
//		
//		//Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in
//		//Amazon Sign In
//		
//		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		String actualTitle = driver.getTitle();
//		Assert.assertEquals(actualTitle, expectedTitle);
//	}
	
	@Test 
	public void verifyTextOnLoginPage() 
	{
		testID = "Test-TC02";
		System.out.println("Test3");
		
		String expectedText = "Create your Amazon account123";
		String actualText = loginpage.getTextOnCreateNewAccButton();
		Assert.assertEquals(actualText, expectedText);

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
