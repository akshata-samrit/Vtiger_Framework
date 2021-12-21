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


/**
 * 
 * @author Akshata
 *
 */

public class TC_06CreateFilterTest 
{
	@Test
	public static void createFilterAndClickOnCancelButton() throws Throwable 
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
		
		String parent = driver.getWindowHandle();

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
		System.out.println(actualTitle2);
		wdUtil.switchToWindow(driver, actualTitle2);
		driver.findElement(By.linkText("Marketing")).click();
		driver.switchTo().window(parent);
		
		WebElement closingDate = driver.findElement(By.name("closingdate"));
		closingDate.clear();
		closingDate.sendKeys("2021-10-15");
		
		WebElement salesStageDropDown = driver.findElement(By.name("sales_stage"));
		wdUtil.SelectOption(salesStageDropDown, "Closed Lost");
		
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();

		System.out.println("Opportunity Created");
		
		driver.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();


		driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
		
		String viewName = eUtil.getExcelData("Sheet2", 4, 1);
		driver.findElement(By.name("viewName")).sendKeys(viewName);
		
		driver.findElement(By.name("setDefault")).click();
		driver.findElement(By.name("setMetrics")).click();
		driver.findElement(By.name("setStatus")).click();
		
		WebElement selectColumn = driver.findElement(By.name("stdDateFilterField"));
		wdUtil.SelectOption(selectColumn, "Oppurtunities - Modified Time");
		
		WebElement selectDuration = driver.findElement(By.name("stdDateFilter"));
		wdUtil.SelectOption(selectDuration, "Next Week");
		
		driver.findElement(By.xpath("//b[text()='Advanced Filters']")).click();
		
		WebElement typeDropdown = driver.findElement(By.name("fcol0"));
		wdUtil.SelectOption(typeDropdown, "Campaign Source");
		
		WebElement dropDown = driver.findElement(By.name("fop0"));
		wdUtil.SelectOption(dropDown, "contains");
		
		driver.findElement(By.xpath("//input[@value='Cancel']")).click();
		
		String filterExpected = "Filters :";
		String filterActual =driver.findElement(By.xpath("//font[text()='Filters :']")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(filterActual, filterExpected);
		
		System.out.println("Click on Cancel Button And All the Fields Are Clear");
		
		driver.close();
		s.assertAll();
	}
}
