package com.crm.vtiger.GenericUtils;

import org.testng.ITestResult;

public class RetryAnalyzer 
{
	int count = 0;
	int retryCount = 3;
	
	public boolean retry(ITestResult result)
	{
		while (count<retryCount)
		{
			return true;
		}
		return false;
	}
}
