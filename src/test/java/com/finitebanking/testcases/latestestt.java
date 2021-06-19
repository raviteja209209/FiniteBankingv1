package com.finitebanking.testcases;

public class latestestt {
	package com.finitebanking.testcases;

	import com.finitebanking.pageobjects.LoginPage;

	public class updatedtestcase {

	}
	LoginPage lp=new LoginPage(driver);
	lp.setusername(user);
	logger.info("user name provided");
	lp.setpassword(pwd);
	logger.info("password provided");
	lp.clickSubmit();

	Thread.sleep(3000);
}
