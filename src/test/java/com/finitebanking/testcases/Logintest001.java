package com.finitebanking.testcases;
import com.finitebanking.pageobjects.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Logintest001  extends BaseClass{
	@Test
	public void loginTest() throws IOException	
	{
		driver.get(URL);
		logger.info("URL opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("username entered");
		lp.setpassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		
if(driver.getTitle().equals("Guru99 Bank Manager HomePage9999"))
{
	Assert.assertTrue(true);	
	logger.info("test passed");
}
else
{
	captureScreen(driver,"loginTest");
	Assert.assertTrue(false);		
    logger.info("test failed");
}
}
}
