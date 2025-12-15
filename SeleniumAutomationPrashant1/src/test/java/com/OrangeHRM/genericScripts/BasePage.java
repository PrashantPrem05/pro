package com.OrangeHRM.genericScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AdminPage;
import pageObject.LoginPage;
import pageObject.Logout;
import pageObject.PimPageObject;
public class BasePage implements I_Appilcaton_Constant
{	
	public static WebDriver driver;
	public LoginPage lp;
	public Logout lgt;
	public PimPageObject pim;
	public AdminPage ap;
	ReadProperty rp;
	@Parameters("Browsers")
	@BeforeClass
	public void Before() throws Exception
	{
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
//		if(Browsers=="chrome")
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if (Browsers=="firefox")
//		{
//			WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		}
//		else
//		{
//			System.out.println("Invalid browser");
//		}
//		switch (Browsers.toLowerCase()) {
//		case "chrome":WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case "firefox":WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//			break;
//
//		default: System.out.println("Invalid browser");
//			
//		}
	
	 
	 rp =new ReadProperty();
	 System.out.println("hi");
	 String url= rp.TestUrl1();
	 driver.get(url);
	 driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
	 lp = new LoginPage(driver);
	 lgt = new Logout(driver);
	 pim =  new PimPageObject(driver);	
	 ap=new AdminPage(driver);
	}
	@BeforeMethod
	public void Launch() throws Exception
	{
		
		lp.usn12().sendKeys(rp.Username());
		lp.pass12().sendKeys(rp.TestPass());
			lp.login12().click();
	}
	@AfterMethod
	public void Logout1() throws InterruptedException
	{
		Thread.sleep(6000);
		lgt.usn1().click();
		lgt.lout().click();
	}
	@AfterClass
	public void Close() throws InterruptedException 
	{
		
		driver.quit();
	}

}
