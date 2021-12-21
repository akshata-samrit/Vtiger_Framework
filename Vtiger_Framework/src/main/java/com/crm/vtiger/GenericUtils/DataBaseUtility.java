package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class contains generic methods to read data from Database
 * @author Akshata
 *
 */
  
public class DataBaseUtility
{
	Connection con = null;
	ResultSet result = null;
	Driver driverRef;
	
	/**
	 * Connection with Database is Established
	 * @throws Throwable
	 */
	public void connectionToDB() throws Throwable
	{
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	}
	
	
	/**
	 * DB Connection is Closedb
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	
	/**
	 * This method is return data with respect to column index
	 * @param query
	 * @param Columnindex
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query, int Columnindex) throws Throwable
	{
		String value = null;
		result = con.createStatement().executeQuery(query);
		
		while(result.next())
		{
			value = result.getString(Columnindex);
		}
		return value;
	}
	
	/**
	 * Get data from DB and Verify
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromDB(String query, int columnName, String expData) throws Throwable
	{
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(columnName).equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
	
		if(flag)
		{
			System.out.println(expData + "Data Verified in Database");
			return expData;
		}
		else
		{
			System.out.println(expData + "Data Not Verified");
			return expData;
		}
	}
}
