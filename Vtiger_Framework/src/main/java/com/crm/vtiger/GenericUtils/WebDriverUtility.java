package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Akshata
 *
 */

public class WebDriverUtility 
{	
	private static final String Set = null;


	/**
	 * Implicit Wait
	 * This method wait for 20 sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 * Explicit Wait
	 * This method wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method is Maximize the Window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * Thread.sleep();
	 * This method is wait for the element to be clicked
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count = 0;
		while(count<40)
		{
			try
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	
	/**
	 * This methods enables user to handle dropdown using Visible Text
	 * @param element
	 * @param option
	 * @return 
	 */
	public void SelectOption(WebElement element, String option)
	{
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	
	/**
	 * This methods enables user to handle dropdown using Index
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
	/**
	 * This method will perform Mouse Over Action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This method performs Right Click Operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * This method helps to switch from one window to another
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		
		while(it.hasNext())
		{
			String winId = it.next();
			String childId = it.next();
			String titile = driver.switchTo().window(childId).getTitle();
			
			if(titile.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	
	
	
	
	/**
	 * Accept Alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * CancelAlert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * (Vertical Scrolling)
	 * This method is used for scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y= element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	/**
	 * Handle Frames by Index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * handle Frames by WebElement
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/**
	 * Handle Frames by Id or Name
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	
	/**
	 * This method is used for storing the Screen Shots
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws Throwable 
	 */
	public String takeScreenShot(WebDriver driver,String screenShotname) throws Throwable
	{
		String screenShotPath = "./screenshot"+screenShotname+JavaUtility.getCurrentDate()+".PNG";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(screenShotPath);
		Files.copy(src, dest);
		return screenShotPath;
		
	}
	
	
	/**
	 * This method is used for Robot Class
	 * @throws Throwable
	 */
	public void pressEnterKey() throws Throwable 
	{
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
}
