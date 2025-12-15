package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.genericScripts.Constructor;

public class Logout  extends Constructor 
{
	@FindBy(xpath="(//img[@alt='profile picture'])[1]")
	private WebElement usn1;
	
	
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement lout;
	
	public Logout(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement usn1()
	{
		return usn1;
	}
	
	public WebElement lout()
	{
		return lout;
	}
	

}
