package com.crm.vtiger.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
	// Initialization of Elements
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// Declaration of Elements
	
	@FindBy(name = "search_text")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchButton;

	
	// Getter's Method
	
	public WebElement getSearchTextField() 
	{
		return searchTextField;
	}

	public WebElement getSearchButton() 
	{
		return searchButton;
	}

}
