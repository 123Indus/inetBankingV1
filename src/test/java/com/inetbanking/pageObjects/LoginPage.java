package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	private WebElement user_id;
	
	@FindBy(name="password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	private WebElement btn_login;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	private WebElement logout_btn;
	
	public void setUserName(String uname)
	{
		user_id.sendKeys(uname);
	}
	
	public void setPassword(String pw)
	{
		password.sendKeys(pw);
	}
	
	public void clickSubmit()
	{
		btn_login.click();
	}
	
	public void clickLogout()
	{
		logout_btn.click();
	}

	
}
