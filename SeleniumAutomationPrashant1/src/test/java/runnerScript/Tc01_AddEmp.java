package runnerScript;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.genericScripts.BasePage;
import pageObject.LoginPage;
import utilities.HandleDropdown;
import utilities.MouseActions;
import utilities.ReadExcel;

public class Tc01_AddEmp extends BasePage

{
	@DataProvider(name= "testData")
	public String[][] Tc01_Add_Emp() throws Exception
	{
		
		int lastRow = ReadExcel.LastRowNumber(Excelpath, "Sheet1");
		int lastcell = ReadExcel.LastCellNumber(Excelpath, "Sheet1");
		String[][] empData = new String[lastRow+1][lastcell];
		for(int r=0;r<=lastRow;r++)
		{
					//XSSFRow row = ReadExcel.AccessRow(Excelpath, "Sheet1", r);
					for(int c=0;c<lastcell;c++)
					{	
						String val = ReadExcel.AccessCellValue(Excelpath, "Sheet1", r, c);
						empData[r][c]=val;
					//System.out.print(val +"\t");
		}
		//System.out.println();
	}
		return empData;
}
	
	@Test(dataProvider = "testData")
	public void Tc_Add_Emp(String fn,String ln ,String mn)
	{
		lp.pim_btn().click();
		pim.Addemp().click();
		
		pim.fname().sendKeys(fn);
		pim.mname().sendKeys(mn);
		pim.lname().sendKeys(ln);
//		WebDriverWait eew = new WebDriverWait(driver, 10);
//		eew.until(ExpectedConditions.visibilityOf(pim.save()));
		pim.save().click();
		MouseActions.RightClick(ap.add_btn());
	//	Dropdown.selectByIndex1();
	}
		
		
		
		
		
		
		
		
		
		
		
	}
		
//		
//		
//	}
//}
