package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class LoginPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	// Declaration of Elements
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	
	// Getter's Method
	
	public WebElement getUserName() 
	{
		return userNameEdt;
	}

	public WebElement getPassword() 
	{
		return passwordEdt;
	}

	public WebElement getLoginButton() 
	{
		return loginButton;
	}
	
	
	// Business Logic
	
	
	public void login(String userName , String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}

	
}
