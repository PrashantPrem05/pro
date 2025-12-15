package com.OrangeHRM.genericScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Constructor 
{
	public Constructor(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}
