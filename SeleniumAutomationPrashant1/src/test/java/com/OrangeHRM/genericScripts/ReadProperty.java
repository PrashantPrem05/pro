package com.OrangeHRM.genericScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperty implements I_Appilcaton_Constant 
{
	Properties ps;
	public  ReadProperty() throws Exception
	{
		FileInputStream fis = new FileInputStream(path);
		 ps = new Properties();
		ps.load(fis);
		

		}
		
	public String TestUrl1()
	{
		return ps.getProperty(urlKey);
		
	}
	public String Username()
	{
		return ps.getProperty(usnKey);	
		
	}
	public String TestPass()
	{
		return ps.getProperty(passKey);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	String url = ps.getProperty("testUrl");
//	String usn = ps.getProperty("usn");
//	String pass = ps.getProperty("pass");
//	BasePage bp = new BasePage();	
//	bp.Before(url,usn,pass);
//	
//	public void TestData()
//	{
//		String url = ps.getProperty("testUrl");
//		String usn = ps.getProperty("usn");
//		String pass = ps.getProperty("pass");
//	}
//	
//	public String[] arr()
//	{
//	String [] arr = new String[5];
//	
//	arr[0]=ps.getProperty("testUrl");
//	arr[1]=ps.getProperty("usn");
//	arr[2]=ps.getProperty("pass");
//	return arr;
//	}

}

