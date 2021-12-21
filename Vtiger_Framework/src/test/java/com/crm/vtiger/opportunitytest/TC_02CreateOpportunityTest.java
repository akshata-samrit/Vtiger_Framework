package com.crm.vtiger.opportunitytest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepository.lib.CreateCampaignPage;
import com.crm.vtiger.pomrepository.lib.CreateNewOpportunityPage;
import com.crm.vtiger.pomrepository.lib.HomePage;
import com.crm.vtiger.pomrepository.lib.LoginPage;
import com.crm.vtiger.pomrepository.lib.OpportunityInfoPage;
import com.crm.vtiger.pomrepository.lib.OpportunityPage;

public class TC_02CreateOpportunityTest extends BaseClass
{
	@Test(groups={"RegressionTest"})
	public void createOpportunityWithoutFillingMandatoryDetails() throws Throwable
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
		
		// Create a New Opportunity Without Filling MAndatory Fields And CLick On Save Button
		CreateNewOpportunityPage cop = new CreateNewOpportunityPage(driver);
		cop.getSaveButton().click();
		
		// Validation With Alert Pop Up
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);
		oip.verifyAlertPopUpWithoutMandatoryFields();
		
		System.out.println("PASSED :: Opportunity Name cannot be empty : Click on OK Button of alert Pop UP");
		
	}
}
