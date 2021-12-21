  package com.crm.vtiger.GenericUtils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.pomrepository.lib.HomePage;
import com.crm.vtiger.pomrepository.lib.LoginPage;


/**
 * This class contains Basic Configuration Annotations of TestNG
 * @author Akshata
 *
 */

public class BaseClass 
{
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	
	public WebDriver driver;
	public static WebDriver staticDriver;     // null
	public EventFiringWebDriver eventDriver;
	
	@BeforeSuite
	public void connectionDB() throws Throwable
	{
		//dLib.connectionToDB();
		System.out.println("==========DB Connection Successful==========");
	}
		
	@Parameters("browser")               // Chrome , Firefox
	@BeforeClass(groups={"SmokeTest","RegressionTest"})
	public void launchBrowser(@Optional("chrome") String browser) throws Throwable
	{
		System.out.println("Launching Browser : " + browser);
		
		// Read data from JSON File
	//	String browser = fLib.getDataFromJSON("browser");
		String URL = fLib.getDataFromJSON("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name" + browser);
		}
		staticDriver = driver ;  // Assigning driver reference
		WebDriverListner regDriver=new WebDriverListner();
		eventDriver=new EventFiringWebDriver(driver);
		eventDriver.register(regDriver);
		
		System.out.println("==========Browser Launch Successful==========");

		wLib.maximiseWindow(driver);
		wLib.waitUntilPageLoad(driver);
		driver.get(URL);

	}
	
	@BeforeMethod(groups={"SmokeTest","RegressionTest"})
	public void loginToApp() throws Throwable
	{
		// Read data from JSON File
		String USERNAME = fLib.getDataFromJSON("username");
		String PASSWORD = fLib.getDataFromJSON("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("===========Login Successful==========");
	}
	
	@AfterMethod(groups={"SmokeTest","RegressionTest"})
	public void logoutFromApp()
	{
		// Signout of Home Page
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("==========Sign Out Successful==========");
	}

	@AfterClass(groups={"SmokeTest","RegressionTest"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("==========Browser Closed Successfully==========");

	}
	
	@AfterSuite
	public void closeDB()
	{
		//dLib.closeDB();
		System.out.println("==========DB Connection Closed Successfully==========");
	}
	
}
