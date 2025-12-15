package runnerScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OrangeHRM.genericScripts.BasePage;

import utilities.HandleDropdown;

public class Tc_Admin_Add extends BasePage
{
	@Test
	public void Tc_Admin() throws InterruptedException
	{
		
		lp.admin_btn().click();
		ap.add_btn().click();
//		ap.status().click();
//		ap.status_button().click();
		//HandleDropdown.SelectBy(ap.status(), "Enabled");
		ap.emp_name().sendKeys("abc bac");
		Thread.sleep(2000);
		ap.emp_name().sendKeys(Keys.ARROW_DOWN);
		ap.emp_name().sendKeys(Keys.ENTER);
//		WebDriverWait ew = new WebDriverWait(driver, 10);
//		ew.until(ExpectedConditions.visibilityOfElementLocated((By.xpath))
		ap.user_role().click();
		ap.emp_name().sendKeys("abc");
		ap.select_admin().click();
		ap.status().click();
		ap.status_button().click();
		ap.username().sendKeys("admin00");
		
		ap.pass().sendKeys("a1234000");
		ap.confirmpass().sendKeys("a1234000");
		ap.save().click();
	}
	
	
}
