package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.Allure_Listeners;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners(Allure_Listeners.class)
public class TC_LoginTest_001 extends BaseClass {
	
	@Test(priority=0 , description="Verify the login should be successful")
	@Description("Verify login should be successful...")
	@Epic("EP001")
	@Feature("Feature 1: logo")
	@Severity(SeverityLevel.CRITICAL)
	
	public void LoginTest() throws InterruptedException, IOException {
		
		Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("Username is successfully filled");
		
		lp.setPassword(password);
		log.info("Password is successfully filled");
		
		lp.clickSubmit();
		log.info("Succcessfully click on login button");
		
		Thread.sleep(2000);
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Login test pass");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			log.info("Login test fail");
		}
		
	}
	
	
	
	
	
	

}
