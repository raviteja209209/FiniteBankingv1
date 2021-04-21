package com.finitebanking.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.finitebaking.utilites.ReadConfig;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

public class BaseClass {
ReadConfig readconfig = new ReadConfig();
public String URL = readconfig.getApplicationURL();
public String username = readconfig.getUsername();
public String password = readconfig.getPassword();
public static WebDriver driver;
public static Logger logger;

@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	 logger = Logger.getLogger("finitebanking");
	 PropertyConfigurator.configure("Log4j.properties");	 
	if(br.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
	driver = new ChromeDriver();
	}
	else if (br.equals("firefox"))
	{
	System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
	driver = new FirefoxDriver();
	}
	else if (br.equals("ie"))
	{
	System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
	driver = new InternetExplorerDriver();
	}
	driver.get(URL);
}

@AfterClass
public void teardown()
{
	driver.quit();
}
public void captureScreen(WebDriver driver,String tname) throws IOException {
TakesScreenshot ts = (TakesScreenshot)driver;
File source = ts.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
FileUtils.copyFile(source,target);
System.out.println("screenshot taken");
}
public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}


}

