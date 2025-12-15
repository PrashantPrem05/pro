package propertiesfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class genericProperty {

	
	@Test
	public String genericdata(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String name1 = prop.getProperty(key);
		return name1;

	}
	
	@Test
	public void runner() throws IOException
	{
				System.out.println(genericdata("name"));

	}
}
