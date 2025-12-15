package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.OrangeHRM.genericScripts.BasePage;

public class GetDefect extends BasePage
{
	public static void CaptureDefect(String Filename) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File(DefectsPath+CurrentTimeZone.currentTimeZone()+" "+Filename+".png");
		FileHandler.copy(temp, perm);
		System.out.println(perm.getAbsolutePath());
	}
}
