package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

import junit.framework.Assert;


/**
 * 
 * @author Akshata
 *
 */

public class TC_01CreateOpportunityTest 
{
	@Test
	public static void createOpportunityWithSalesStagedClosed() throws Throwable 
	{
		WebDriver driver = new ChromeDriver();
		
		FileUtility fileUtil = new FileUtility();
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();

		driver.manage().window().maximize();
		
		wdUtil.waitUntilPageLoad(driver);

		String url = fileUtil.getDataFromJSON("url");
		driver.get(url);
		String username = fileUtil.getDataFromJSON("username");
		String password = fileUtil.getDataFromJSON("password");
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		
		WebElement quickCreate = driver.findElement(By.id("qccombo"));
		wdUtil.SelectOption(quickCreate, "New Campaign");
		
		String campaignName = eUtil.getExcelData("Sheet2", 1, 2);
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		
		WebElement campaignType = driver.findElement(By.name("campaigntype"));
		wdUtil.SelectOption(campaignType, "Advertisement");
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		
		WebElement campaignClosingDate = driver.findElement(By.name("closingdate"));
		campaignClosingDate.clear();
		campaignClosingDate.sendKeys("2021-10-15");
		
		WebElement expectedResponse = driver.findElement(By.name("expectedresponse"));
		wdUtil.SelectOption(expectedResponse, "Excellent");
		
		WebElement campaignStatus = driver.findElement(By.name("campaignstatus"));
		wdUtil.SelectOption(campaignStatus, "Active");
		
		String parent = driver.getWindowHandle();

		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();

		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();

		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		
		String opportunityName = eUtil.getExcelData("Sheet2", 1, 1);
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		
		WebElement relatedToDropDown = driver.findElement(By.name("related_to_type"));
		wdUtil.SelectOption(relatedToDropDown, "Organizations");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		String actualTitle1 = driver.getTitle();
		System.out.println(actualTitle1);
		wdUtil.switchToWindow(driver, actualTitle1);
		driver.findElement(By.linkText("Citi Bank")).click();
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assignedToDropDown = driver.findElement(By.name("assigned_group_id"));
		wdUtil.SelectOption(assignedToDropDown, "Team Selling");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
		String actualTitle2 = driver.getTitle();
		wdUtil.switchToWindow(driver, actualTitle2);
		driver.findElement(By.linkText("Marketing")).click();
		driver.switchTo().window(parent);
				
		WebElement closingDate = driver.findElement(By.name("closingdate"));
		closingDate.clear();
		closingDate.sendKeys("2021-10-15");
		
		WebElement salesStageDropDown = driver.findElement(By.name("sales_stage"));
		wdUtil.SelectOption(salesStageDropDown, "Closed Lost");
				
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		
		String salesStageExpected = "Closed Lost";
		String salesStageActual = driver.findElement(By.xpath("//font[text()='Closed Lost']")).getText();
		System.out.println(salesStageActual);
		SoftAssert s =new SoftAssert();
		s.assertEquals(salesStageExpected, salesStageActual);
		
		System.out.println("Opportunity Created with Sales Stage Closed Lost");
		
		driver.close();
		s.assertAll();
	}
}
