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

public class OpportunityInfoPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public OpportunityInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	// Declaration of Elements
	
	@FindBy(xpath ="//font[text()='Closed Lost']")
	private WebElement salesStageActual;

	
	// Getter's Method
	
	public WebElement getSalesStageActual() 
	{
		return salesStageActual;
	}
	
	
	// Business Logic
	
	
	public void verifyWithClosedLost() throws Throwable
	{
		String salesStageExpected = eLib.getExcelData("Sheet2", 1, 3);
		String actualSalesStage = getSalesStageActual().getText();
		Assert.assertEquals(salesStageExpected, actualSalesStage);
	}
	
	public void verifyAlertPopUpWithoutMandatoryFields() throws Throwable
	{
		Alert alert = driver.switchTo().alert();
		String alertTextActual = alert.getText();
		String alertTextExpected = eLib.getExcelData("Sheet2", 7, 1);
		wLib.acceptAlert(driver);
		
		Assert.assertEquals(alertTextActual, alertTextExpected);

	}
	
		
}
