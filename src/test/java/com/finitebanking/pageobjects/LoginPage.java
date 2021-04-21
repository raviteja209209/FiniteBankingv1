package com.finitebanking.pageobjects;

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
WebElement txtusername;

@FindBy(name="password")
@CacheLookup
WebElement txtpassword;

@FindBy(name="btnLogin")
@CacheLookup
WebElement btnlogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
@CacheLookup
WebElement lnkLogout;

public void setusername(String username)
{
	txtusername.sendKeys(username);
}

public void setpassword(String password)
{
	txtpassword.sendKeys(password);
}

public void clickSubmit()
{
	btnlogin.click();
}
public void clickLogout()
{
	lnkLogout.click();
}
}


