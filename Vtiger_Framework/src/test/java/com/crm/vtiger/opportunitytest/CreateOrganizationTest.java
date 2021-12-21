package com.crm.vtiger.opportunitytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomrepository.lib.CreateOrganizationPage;
import com.crm.vtiger.pomrepository.lib.HomePage;
import com.crm.vtiger.pomrepository.lib.LoginPage;
import com.crm.vtiger.pomrepository.lib.OrganizationPage;
import com.crm.vtiger.pomrepository.lib.OrganizationsInfoPage;

import junit.framework.Assert;

@Listeners(com.crm.vtiger.GenericUtils.ListnerImplementation.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test/*(retryAnalyzer = com.crm.vtiger.GenericUtils.RetryAnalyzer.retry(ITestResult))*/
	public void CreateOrganizationTest() throws Throwable 
	{
		// Read test data from Excel
		String ORGNAME = eLib.getExcelData("Sheet1", 1, 1) + jLib.getRandomData();
		System.out.println(ORGNAME);
		
		// Click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizations();
		
		// Click on Create Organization Image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		// Enter the Mandatory Fields
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(ORGNAME);
		
		// Validation
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String actualData = oip.getOrganizationInformation().getText();
		System.out.println(actualData);
		Assert.assertTrue(actualData.contains(ORGNAME));
		System.out.println("Organization Created Sucessfully");

		
		Assert.fail();
	}

	




}
