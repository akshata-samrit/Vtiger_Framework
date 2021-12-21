package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;

public class OrganizationsInfoPage extends BaseClass
{
	// Initialization of Elements

	WebDriver driver;
	public OrganizationsInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInformation;

	
	// Getter's Method

	public WebElement getOrganizationInformation() 
	{
		return organizationInformation;
	}
}
