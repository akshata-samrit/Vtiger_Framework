package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;

public class OrganizationPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationButton;
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;

	
	// Getter's Method
	
	public WebElement getSearchTextField()
	{
		return searchTextField;
	}

	public WebElement getSearchButton()
	{
		return searchButton;
	}

	public WebElement getCreateOrganizationButton() 
	{
		return createOrganizationButton;
	}
	
	
	// Business Logic

	
	public void clickOnCreateOrgImg()
	{
		createOrganizationButton.click();
	}
}
