package runnerScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.genericScripts.BasePage;

import utilities.MouseActions;

public class Tc_02Verify extends BasePage
{
	@Test
	public void Tc02() 
	{
		String Exp= "Dashboard";
		String act=lp.dashtitle().getText();
		Assert.assertEquals(act, Exp);
		MouseActions.RightClick(ap.add_btn());
		//HandleDropdown.S
	}
}
