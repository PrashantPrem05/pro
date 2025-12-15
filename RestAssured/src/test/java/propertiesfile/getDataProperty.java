package propertiesfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class getDataProperty {
	 
	@Test
	public void data() throws IOException
	{
		FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String name = prop.getProperty("name");
		System.out.println(name);
		String job = prop.getProperty("job");
		System.out.println(job);
		String name1 = prop.getProperty("name");
		System.out.println(name1);
		
	}

}
