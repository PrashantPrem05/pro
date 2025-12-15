package propertiesfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class SetPropertyData {
	@Test
	public void setData() throws IOException
	{
		FileOutputStream fis = new FileOutputStream("./Data/commonData.properties", true);
		Properties pro = new Properties();
		pro.setProperty("flower", "rose");
		pro.store(fis, "data entered");
		
	}

}
