package utilities;

import java.util.Date;

public class CurrentTimeZone
{
	public static String currentTimeZone()
	{
		 Date d=new Date();
		 String d1 = d.toString();
		 String d2= d1.replace(":", "-");
		 return d2;
	}
}
