package testScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class TC_02CreateOpportunityTest 
{
	@Test
	public static void createOpportunityWithoutFillingMandatoryDetails() throws Throwable 
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

		driver.findElement(By.xpath("(//img[@title='Select'])[2]")).click();
		String actualTitle1 = driver.getTitle();
		System.out.println(actualTitle1);
		wdUtil.switchToWindow(driver, actualTitle1);
		driver.findElement(By.linkText("Marketing")).click();
		driver.switchTo().window(parent);
			
		driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
		
		Alert alert = driver.switchTo().alert();
		String alertTextActual = alert.getText();
		String alertTextExpected = "Opportunity Name cannot be empty";
		wdUtil.acceptAlert(driver);
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(alertTextActual, alertTextExpected);
		
		System.out.println("Opportunity Name cannot be empty : Click on OK Button of alert Pop UP");
		
		driver.close();
		s.assertAll();
	}
}
