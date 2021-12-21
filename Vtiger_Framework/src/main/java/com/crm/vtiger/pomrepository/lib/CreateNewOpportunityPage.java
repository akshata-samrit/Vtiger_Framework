package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewOpportunityPage extends BaseClass
{
	// Initialization of Elements
	
	WebDriver driver;
	public CreateNewOpportunityPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(name = "potentialname")
	private WebElement opportunityName;
	
	@FindBy(name = "related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement relatedToLookUpIcon;
	
	@FindBy(linkText = "Citi Bank")
	private WebElement createdOrganizationName;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement campaignSourceLookUpIcon;
	
	@FindBy(linkText = "Marketing")
	private WebElement campaignName;
	
	@FindBy(name = "closingdate")
	private WebElement expectedCloseDate;
	
	@FindBy(name = "sales_stage")
	private WebElement salesStage;
	
	@FindBy(xpath = "(//input[@value='  Save  '])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//input[@value='  Cancel  '])[2]")
	private WebElement cancelButton;
	
	
	
	// Getter's Method
		
	public WebElement getOpportunityName() 
	{
		return opportunityName;
	}

	public WebElement getRelatedToDropDown()
	{
		return relatedToDropDown;
	}

	public WebElement getRelatedToLookUpIcon() 
	{
		return relatedToLookUpIcon;
	}

	public WebElement getCreatedOrganizationName()
	{
		return createdOrganizationName;
	}

	public WebElement getGroupRadioButton()
	{
		return groupRadioButton;
	}

	public WebElement getAssignedToDropDown() 
	{
		return assignedToDropDown;
	}

	public WebElement getCampaignSourceLookUpIcon() 
	{
		return campaignSourceLookUpIcon;
	}

	public WebElement getCampaignName() 
	{
		return campaignName;
	}

	public WebElement getExpectedCloseDate() 
	{
		return expectedCloseDate;
	}

	public WebElement getSalesStage()
	{
		return salesStage;
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
	
	public void opportunityNameTextField(String oppName)
	{
		opportunityName.sendKeys(oppName);
	}
	
	public void createopportunityWithOrganization()
	{
		wLib.SelectOption(relatedToDropDown, "Organizations");
		relatedToLookUpIcon.click();
		String parent=driver.getWindowHandle();
		wLib.switchToWindow(driver, "Accounts&action");
//		OrganizationPage orgp = new OrganizationPage(driver);
//		orgp.getSearchTextField().sendKeys(orgName);
//		orgp.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='Citi Bank']")).click();
		
		driver.switchTo().window(parent);
		
		groupRadioButton.click();
		wLib.SelectOption(assignedToDropDown, "Team Selling");
		
		campaignSourceLookUpIcon.click();
		wLib.switchToWindow(driver, "Campaigns&action");
//		CampaignPage cp = new CampaignPage(driver);
//		cp.getSearchTextField().sendKeys(campName);
//		cp.getSearchButton().click();
		driver.findElement(By.xpath("//a[text()='Marketing']")).click();
		
		driver.switchTo().window(parent);
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.date();
		
		wLib.SelectOption(salesStage, "Closed Lost");
		
	}
	
	public void createOpportunity(String oppName)
	{
		opportunityNameTextField(oppName);
		createopportunityWithOrganization();
	}

}
