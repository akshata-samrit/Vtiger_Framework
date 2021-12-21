package com.crm.vtiger.pomrepository.lib;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateFilterPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	
	public CreateFilterPage(WebDriver driver)
	{	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(name = "viewName")
	private WebElement viewName;
	
	@FindBy(name = "setDefault")
	private WebElement setDefault;
	
	@FindBy(name = "setMetrics")
	private WebElement setMetrics;
	
	@FindBy(name = "setStatus")
	private WebElement setStatus;
	
	@FindBy(name = "column1")
	private WebElement column1;

	@FindBy(name = "column2")
	private WebElement column2;

	@FindBy(name = "column3")
	private WebElement column3;

	@FindBy(name = "column4")
	private WebElement column4;

	@FindBy(name = "column5")
	private WebElement column5;

	@FindBy(name = "stdDateFilterField")
	private WebElement selectColumn;
	
	@FindBy(name = "stdDateFilter")
	private WebElement selectDuration;
	
	@FindBy(xpath = "//b[text()='Advanced Filters']")
	private WebElement advancedFilters;
	
	@FindBy(name = "fcol0")
	private WebElement typeDropDown;
	
	@FindBy(name = "fop0")
	private WebElement dropDown;
	
	@FindBy(xpath = "(//input[@value='Save'])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@value='Cancel']")
	private WebElement cancelButton;
	
	
	// Getter's Method
	
	public WebElement getViewName() 
	{
		return viewName;
	}

	public WebElement getSetDefault()
	{
		return setDefault;
	}

	public WebElement getSetMetrics() 
	{
		return setMetrics;
	}

	public WebElement getSetStatus() 
	{
		return setStatus;
	}

	public WebElement getColumn1()
	{
		return column1;
	}

	public WebElement getColumn2()
	{
		return column2;
	}

	public WebElement getColumn3()
	{
		return column3;
	}

	public WebElement getColumn4() 
	{
		return column4;
	}

	public WebElement getColumn5() 
	{
		return column5;
	}

	public WebElement getSelectColumn() 
	{
		return selectColumn;
	}

	public WebElement getSelectDuration() 
	{
		return selectDuration;
	}

	public WebElement getAdvancedFilters()
	{
		return advancedFilters;
	}

	public WebElement getTypeDropDown() 
	{
		return typeDropDown;
	}

	public WebElement getDropDown() 
	{
		return dropDown;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public WebElement getCancelButton()
	{
		return cancelButton;
	}
	
	
	
	// Business Logic
	
	public void createFilterName(String vName)
	{
		viewName.sendKeys(vName);
	}
	
	
	public void dropDown()
	{
		wLib.SelectOption(column1, "Opportunity No");
		wLib.SelectOption(column2, "Next Step");
		wLib.SelectOption(column3, "Campaign Source");
		wLib.SelectOption(column4, "Lead Source");
		wLib.SelectOption(column5, "Amount");
	}
	
	public void options()
	{
		setDefault.click();
		setMetrics.click();
		setStatus.click();
		
		wLib.SelectOption(selectColumn, "Oppurtunities - Modified Time");
		wLib.SelectOption(selectDuration, "Next Week");
		
		advancedFilters.click();
		
		wLib.SelectOption(typeDropDown, "Campaign Source");
		wLib.SelectOption(dropDown, "contains");
		
		
	}
	
	public void createFilterWithMandateFields(String vName)
	{
		createFilterName(vName);
		options();
	}
	
	public void createFilterWithoutMandateFields()
	{
		dropDown();
		options();
	}
	
	
	public void verifyCreateFilterWithoutMandatoryFields() throws Throwable
	{
		Alert alert = driver.switchTo().alert();
		String alertTextActual = alert.getText();
		System.out.println(alertTextActual);
		String alertTextExpected = eLib.getExcelData("Sheet2", 13, 1);
			
		wLib.acceptAlert(driver);
		
		Assert.assertEquals(alertTextExpected, alertTextActual);
	}
}
