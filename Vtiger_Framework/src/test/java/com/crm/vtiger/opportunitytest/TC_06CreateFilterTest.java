package com.crm.vtiger.opportunitytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepository.lib.CreateCampaignPage;
import com.crm.vtiger.pomrepository.lib.CreateFilterPage;
import com.crm.vtiger.pomrepository.lib.CreateNewOpportunityPage;
import com.crm.vtiger.pomrepository.lib.HomePage;
import com.crm.vtiger.pomrepository.lib.LoginPage;
import com.crm.vtiger.pomrepository.lib.OpportunityPage;

public class TC_06CreateFilterTest extends BaseClass 
{
	@Test(groups={"AdhocTest"})
	public void createFilterAndClickOnCancelButton() throws Throwable
	{
		// Click on New Campaign From Quick Create Drop Down
		HomePage hp = new HomePage(driver);
		hp.quickCreate();
			
		// Creating a New Campaign
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		
		// Read the data from Excel for Campaign Name
		String campaignName = eLib.getExcelData("Sheet2", 1, 2);
		ccp.createCampaign(campaignName);

		// Click on Opportunity Link
		hp.getOpportunityButton().click();

		// Click on Create Opportunity plus Icon Image
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOpportunity().click();
		
		// Create a New Opportunity With Sales Stage Closed Lost And Click On Save Button
		CreateNewOpportunityPage cop = new CreateNewOpportunityPage(driver);
		
		// Read the data from excel for Opportunity Name
		String opportunityName = eLib.getExcelData("Sheet2", 1, 1);
		cop.createOpportunity(opportunityName);
		cop.getSaveButton().click();

		// Click on Opportunity Link
		hp.getOpportunityButton().click();
		
		// Click On Create Filter Link
		op.getCreateFilter().click();
		
		// Create a New Filter And Click On Cancel Button
		CreateFilterPage cfp = new CreateFilterPage(driver);
		
		// Read the Data From Excel For View Name
		String viewName = eLib.getExcelData("Sheet2", 4, 1);
		cfp.createFilterWithMandateFields(viewName);
		cfp.getCancelButton().click();
		
		// Validation With Previously Created Filter in Drop Down Box
		op.verifyCreateFilterByClickingOnCancelButton();		
		
		System.out.println("PASSED :: Click on Cancel Button And All the Fields Are Clear");
		
		
	}
}
