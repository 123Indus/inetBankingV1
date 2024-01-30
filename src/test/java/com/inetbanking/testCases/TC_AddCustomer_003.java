package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomer;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addnewCustomer() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("username is provided");
		lp.setPassword(password);
		log.info("password is provided");
		lp.clickSubmit();
		log.info("click on submit");
		
		Thread.sleep(3000);
		
		AddCustomer ac=new AddCustomer(driver);
		ac.clicklnkAddNewCustomer();
		Thread.sleep(2000);
		ac.custName("joe");
		ac.custgender("male");
		ac.custdob("10","15","1994");
		Thread.sleep(5000);
		ac.custaddress("INDIA");
		ac.custcity("kolkata");
		Thread.sleep(2000);
		ac.custstate("West Bengal");
		ac.custpinno(578569);
		ac.custtelephoneno("4585685686");
		ac.custemailid(randomstring()+"@yopmail.com");
		ac.custpassword(randompass());
		ac.custsubmit();
		
		Thread.sleep(2000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	/*
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randompass()
	{
		String generatepass = RandomStringUtils.randomAlphanumeric(4,8);
		return generatepass;
	}
*/
}
