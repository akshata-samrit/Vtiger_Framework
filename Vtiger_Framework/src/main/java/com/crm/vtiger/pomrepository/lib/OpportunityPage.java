package com.crm.vtiger.pomrepository.lib;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class OpportunityPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public OpportunityPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunity;
	
	@FindBy(xpath = "//a[text()='Create Filter']")
	private WebElement createFilter;
	
	@FindBy(xpath = "//font[text()='Filters :']")
	private WebElement filter;
	
	@FindBy(name = "viewname")
	private WebElement filterDropDown;
	
	
	// Getter's Method
	
	public WebElement getCreateOpportunity() 
	{
		return createOpportunity;
	}
	
	public WebElement getCreateFilter()
	{
		return createFilter;
	}

	public WebElement getFilter()
	{
		return filter;
	}

	public WebElement getFilterDropDown()
	{
		return filterDropDown;
	}

	
	// Business Logic
	
	public void verifyWithClosedLostByClickingCancelButton() throws Throwable
	{
		String filterExpected = eLib.getExcelData("Sheet2", 10, 1);
		String filterActual = getFilter().getText();
		Assert.assertEquals(filterExpected , filterActual);
	}
	
	
	public void verifyCreateFilterWithSaveButton() throws Throwable
	{
		String filterExpected = eLib.getExcelData("Sheet2", 4, 2);
		Select select = new Select(getFilterDropDown());
		String filterActual = select.getFirstSelectedOption().getText();
		Assert.assertEquals(filterExpected , filterActual);
	}

	public void verifyCreateFilterByClickingOnCancelButton() throws Throwable
	{
		String filterExpected = eLib.getExcelData("Sheet2", 16, 1);
		Select select = new Select(getFilterDropDown());
		String filterActual = select.getFirstSelectedOption().getText();
		Assert.assertEquals(filterExpected , filterActual);

	}
}
