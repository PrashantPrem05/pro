package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.genericScripts.Constructor;

public class LoginPage extends Constructor 
{
	@FindBy(name="username")
	private WebElement usn;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="(//span[.='PIM'])[1]") 
	private WebElement pim_btn;
	
	@FindBy(xpath="//h6[.='Dashboard']") 
	private WebElement dashtitle;
	
	@FindBy(xpath= "//span[.='Admin']")
	private WebElement admin_btn;
	
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
		public WebElement usn12()
	{
		return usn;
	}
		public WebElement pass12()
	{
		return pass;
	}
	public WebElement login12()
	{
		return login;
	}
	public WebElement pim_btn()
	{
		return pim_btn;
	}
	public WebElement dashtitle()
	{
		return dashtitle;
	}
	public WebElement admin_btn()
	{
		return admin_btn;
	}

}
