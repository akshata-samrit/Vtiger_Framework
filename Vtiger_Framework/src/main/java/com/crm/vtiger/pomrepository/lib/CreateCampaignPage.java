package com.crm.vtiger.pomrepository.lib;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateCampaignPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public CreateCampaignPage(WebDriver driver)	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	// Declaration of Elements
	
	@FindBy(name ="campaignname")
	private WebElement campaignName;
	
	@FindBy(name ="campaigntype")
	private WebElement campaignType;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(name = "closingdate")
	private WebElement campaignClosingDate;
	
	@FindBy(name = "expectedresponse")
	private WebElement expectedResponse;
	
	@FindBy(name = "campaignstatus")
	private WebElement campaignStatus;
	
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;
	
	
	// Getter's Method
	
	public WebElement getCampaignName() 
	{
		return campaignName;
	}

	public WebElement getCampaignType()
	{
		return campaignType;
	}

	public WebElement getGroupRadioButton()
	{
		return groupRadioButton;
	}
	
	public WebElement getAssignedToDropDown() 
	{
		return assignedToDropDown;
	}

	public WebElement getCampaignClosingDate() 
	{
		return campaignClosingDate;
	}

	public WebElement getExpectedResponse() 
	{
		return expectedResponse;
	}

	public WebElement getCampaignStatus() 
	{
		return campaignStatus;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}
	
	// Business Logic
	
	public void dropDown()
	{
		wLib.SelectOption(campaignType , "Advertisement");
		wLib.SelectOption(expectedResponse, "Excellent");
		wLib.SelectOption(campaignStatus, "Active");
		groupRadioButton.click();
		wLib.SelectOption(assignedToDropDown, "Team Selling");
	}
	
	public void campaignTextField(String campName)
	{
		campaignName.sendKeys(campName);
	}
	
	public void date()
	{
		Date dateObj = new Date();
		String currentDate = dateObj.toString();
		
		int month = dateObj.getMonth();
		int date = dateObj.getDate();
		String year = currentDate.split("")[5];
		String actDate = year + "-" + month + "-" + date;
		
		WebElement closingDate = driver.findElement(By.name("closingdate"));
//		closingDate.clear();
		closingDate.sendKeys(actDate);
	}
	
	public void createCampaign(String campName)
	{
		campaignTextField(campName);
		dropDown();
		date();
		getSaveButton().click();
		
	}
	
}
