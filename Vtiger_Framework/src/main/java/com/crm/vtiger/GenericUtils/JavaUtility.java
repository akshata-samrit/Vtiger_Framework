package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Akshata
 *
 */
public class JavaUtility 
{
	/**
	 * This method is generate random number to avoid duplicates
	 * @return
	 */
	
	public static String getRandomData()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		
		return "" + ran;
	}
	
	
	/**
	 * @Akshata
	 * This method is used to generate current system date
	 * @return currentDate
	 */
	public static String getCurrentDate()
	{
		Date date = new Date();
		String currentDate = date.toString().replace(" ", "_").replace(":", "_");
		
		return currentDate;
	}
	

}
