package utilities;

import org.openqa.selenium.WebElement;

public class MouseActions
{
	public static void RightClick(WebElement element)
	{
		ActionsObjects.MouseAction().contextClick(element).perform();
	}
	public static void DragAndDrop(WebElement src,WebElement dst)
	{
		ActionsObjects.MouseAction().dragAndDrop(src, dst).perform();
	}
	public static void MouseHover(WebElement element)
	{
		ActionsObjects.MouseAction().moveToElement(element).perform();
	}
	public static void DoubleClick(WebElement element)
	{
		ActionsObjects.MouseAction().doubleClick(element).perform();
	}
	public static void ClickAndHold(WebElement element)
	{
		ActionsObjects.MouseAction().clickAndHold(element).perform();
	}
	public static void Release(WebElement element)
	{
		ActionsObjects.MouseAction().release(element).perform();
	}
	public static void MoveByOffset(int x,int y)
	{
		ActionsObjects.MouseAction().moveByOffset(x,y).perform();
	}
}
