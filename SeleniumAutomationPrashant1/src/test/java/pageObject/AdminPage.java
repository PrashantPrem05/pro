package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.genericScripts.Constructor;

public class AdminPage extends Constructor
{
	@FindBy(xpath="//button[.=' Add ']")
	private WebElement add_btn;
	
	@FindBy(xpath="(//div[.='-- Select --'])[1]")
	private WebElement user_role;
	
	@FindBy(xpath="(//div[.='Admin'])[2]")
	private WebElement select_admin;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement emp_name;	
	
	@FindBy(xpath="(//div[.='-- Select --'])[2]")
	private WebElement status;
	
	@FindBy(xpath="(//input)[3]")
	private WebElement username;
	
	@FindBy(xpath="(//div[.='Enabled'])")
	private WebElement status_button;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement pass;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement confirmpass;
	
	@FindBy(xpath="(//button[@type='submit']")
	private WebElement save;	
	
			
	public AdminPage(WebDriver driver)
	{
		super(driver);	
	}
	
	public WebElement add_btn()
	{
		return add_btn;
	}
	public WebElement user_role()
	{
		return user_role;
	}	
	public WebElement emp_name()
	{
		return emp_name;
	}
	
	public WebElement select_admin()
	{
		return select_admin;
	}
	public WebElement status()
	{
		return status;	
	}
	public WebElement username()
	{
		return username;	
	}
	public WebElement status_button()
	{
		return status_button;	
	}
	public WebElement pass()
	{
		return pass;	
	}
	public WebElement confirmpass()
	{
		return confirmpass;	
	}
	public WebElement save()
	{
		return save;	
	}
	
	
	
	
	
	
}
