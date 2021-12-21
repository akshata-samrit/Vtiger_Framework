package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	// Declaration of Elements
	
	@FindBy(xpath = "(//a[text()='Opportunities'])[1]")
	private WebElement opportunityButton;
	
	@FindBy(id = "qccombo")
	private WebElement quickCreate;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOut;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationButton;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsButton;
	
	
	// Getter's Method
	
	public WebElement getOpportunityButton() 
	{
		return opportunityButton;
	}

	public WebElement getQuickCreate()
	{
		return quickCreate;
	}

	public WebElement getAdministratorIcon() 
	{
		return administratorIcon;
	}

	public WebElement getSignOut() 
	{
		return signOut;
	}
	
		public WebElement getOrganizationButton() 
	{
		return organizationButton;
	}

	public WebElement getContactsButton()
	{
		return contactsButton;
	}

	
	
	// Business Logic
	
	
	public void quickCreate()
	{
		wLib.SelectOption(quickCreate, "New Campaign");
	}
	
	public void clickOnOrganizations()
	{
		organizationButton.click();
	}
	
	public void logout(WebDriver driver)
	{
		wLib.mouseHover(driver, administratorIcon);
		signOut.click();
	}
	
	
}
