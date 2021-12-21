package testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;


//@WebDriverListner
@Listeners(com.crm.vtiger.GenericUtils.ListnerImplementation.class)
public class TestClass extends BaseClass {
	
	@Test
	public void test() {
		System.out.println("run");
		Assert.fail();
	}

}
