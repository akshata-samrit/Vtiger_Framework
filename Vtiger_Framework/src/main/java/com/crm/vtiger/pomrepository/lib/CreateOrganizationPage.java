package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;

public class CreateOrganizationPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public CreateOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(name = "accountname")
	private WebElement organizationName;
	
	@FindBy(xpath = "(//input[@value='  Save  '])[1]")
	private WebElement saveButton;

	
	// Getter's Method
	
	public WebElement getOrganizationName() 
	{
		return organizationName;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}
	
	
	// Business Logic
	
	public void createOrg(String ORGNAME)
	{
		organizationName.sendKeys(ORGNAME);
		saveButton.click();
	}
}
