package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * author @ Akshata	
 */


public class FileUtility 
{
	/**
	 * This method used to read data from properties and return the value based on key specified
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstant.Property_FilePath);
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
	}
	
	/**
	 * 
	 * @param jsonKey
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJSON(String jsonKey) throws Throwable
	{
		FileReader reader = new FileReader(IPathConstant.JSON_FilePath);
		
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject)object;
		String value = jsonObject.get(jsonKey).toString();

		return value;
		
	}
}
