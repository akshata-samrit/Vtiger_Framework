package com.crm.vtiger.GenericUtils;

/**
 * 
 * @author Akshata
 *
 */
// By default it is Static and Final that's why we take interface and store the path here only
// If anyone is changing the path it will take only from interface

public interface IPathConstant 
{
	String Property_FilePath = "./Data/CommonData.properties";
	String JSON_FilePath = "./Data/CommonData.json";
	String Excel_FilePath = "./Data/VtigerTestData.xlsx";
		
}
