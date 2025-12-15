package utilities;

import org.openqa.selenium.WebElement;

public class HandleDropdown 
{
	public static void SelectBy(WebElement element,Object value)
	{
		if (value instanceof Integer)
	{
			ActionsObjects.DropDown(element).selectByIndex((int) value);
	}
	else
	{
		try 
		{
			 ActionsObjects.DropDown(element).selectByValue((String) value);
			
		} catch (Exception e)
		{
			 ActionsObjects.DropDown(element).selectByVisibleText((String) value); 
		}
		
	}
	}
	public static void DeselectBy(WebElement element,Object value)
	{
	if (value instanceof Integer)
	{
		  ActionsObjects.DropDown(element).deselectByIndex((int) value);
	}
	else
	{
		try 
		{
			 ActionsObjects.DropDown(element).deselectByValue((String) value);
			
		} catch (Exception e)
		{
			 ActionsObjects.DropDown(element).deselectByVisibleText((String) value);
		}
		
	}
	
	
	}
}
//	public static void selectByIndex1(WebElement element,int value)
//	{
//		
//		ActionsObjects.DropDown(element).selectByIndex(value);
//	}
//	public static void selectByValue(WebElement element,String value)
//	{
//		ActionsObjects.DropDown(element).selectByValue(value);
//	}
//	public static void selectByVisibleText(WebElement element,String value)
//	{
//		ActionsObjects.DropDown(element).selectByVisibleText(value);
//	}
//	public static void deselectAll(WebElement element)
//	{
//		ActionsObjects.DropDown(element).deselectAll();
//	}
//	public static void deselectbyindex(WebElement element,int value)
//	{
//		ActionsObjects.DropDown(element).deselectByIndex(value);
//	}
//	public static void deselectbyvalue(WebElement element,String value)
//	{
//		ActionsObjects.DropDown(element).deselectByValue(value);
//	}
//	public static void deselectbyvisibleText(WebElement element,String value)
//	{
//		ActionsObjects.DropDown(element).deselectByVisibleText(value);
//	}
//	public static void getAllSelectedOptions(List<WebElement> element)
//	{
//	for(WebElement element1: element )
//	{
//		ActionsObjects.DropDown(element1).getAllSelectedOptions();
//		}
//	}
//	public static void gefirstSelectedOption(WebElement element)
//	{
//		
//		ActionsObjects.DropDown(element).getFirstSelectedOption();
//		}
//	}
	

	
