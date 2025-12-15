package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.genericScripts.Constructor;

public class PimPageObject  extends Constructor 
{
	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement Addemp;
	@FindBy(name="firstName")
	private WebElement fname;
	@FindBy(name="middleName")
	private WebElement mname;
	@FindBy(name="lastName")
	private WebElement lname;
	@FindBy(xpath ="//button[.=' Save ']")
	private WebElement save;
	
	public PimPageObject(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement Addemp()
	{
		return Addemp;
	}
	
	public WebElement fname()
	{
		return fname;
	}
	public WebElement mname()
	{
		return mname;
	}
	public WebElement lname()
	{
		return lname;
	}
	public WebElement save()
	{
		return save;
	}
	
	
}
