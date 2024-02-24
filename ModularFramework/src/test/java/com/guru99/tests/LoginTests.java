package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class LoginTests extends BaseTests{
	
	@Parameters({"username", "password"})
	@Test
	public void verifyUserLoginWithCorrectCredentials (String username, 
			String password) {
		
		reportUtils.createATestCase("verify User Login With Correct Credentials");
		
		reportUtils.addTestLog(Status.INFO, "Performing Login");	
		loginpage.loginToApplication(username, password);	
		String expectedTitle = "Guru99 Bank Manager Home Page";
		String actualTitle = cmnDriver.getPageTitle();	

		reportUtils.addTestLog(Status.INFO, "Comparing Expected and Actual Title");
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
