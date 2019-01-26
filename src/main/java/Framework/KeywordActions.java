package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class KeywordActions {

	public static WebDriver driver;
	
	public KeywordActions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterText(String element, String locator, String locatorvalue, String text) throws Exception
	{
		try {
			getElement(element, locator,locatorvalue).sendKeys(text);
			Log.Info("Entered text in '"+element+"'");
		} catch (Exception e) {
			//Log.Error("");
			DriverScript.result=false;
			Assert.fail("Webelement is null..");
			
		}
		
	}

	public void clickLink(String element, String locator, String locatorvalue, String text) throws Exception
	{
		getElement(element, locator,locatorvalue).click();
		Log.Info("Clicked on '"+element+"' link.");
	}
	
	public void clickButton(String element, String locator, String locatorvalue, String text) throws Exception
	{
		try {
			getElement(element,locator,locatorvalue).click();
			Log.Info("Clicked on '"+element+"' button.");
		} catch (Exception e) {
			Log.Error("Webelement is null..");
		}
		
	}
	
	
	public void selectFromDdown(String element, String locator,  String locatorvalue,String ddowntext) throws Exception
	{
		new Select(getElement(element,locator, locatorvalue)).selectByVisibleText(ddowntext);
		Log.Info("Selected '"+element+"' from the drop down list.");
	}
	
	public void clickRadio(String element, String locator,  String locatorvalue, String text) throws Exception
	{
		getElement(element,locator, locatorvalue).click();
		Log.Info("Clicked on '"+element+"' radio button.");
	}
	
	public  void checkCheckBox(String element, String locator,  String locatorvalue, String text) throws Exception
	{
		getElement(element,locator, locatorvalue).click();
		Log.Info("Clicked on '"+element+"' check box.");
	}
	
	public WebElement getElement(String element, String locator, String locatorvalue) throws Exception 
	{
		WebElement ele=null;
		try {
		if(locator.equals("id"))
			ele= driver.findElement(By.id(locatorvalue));
		
		else if(locator.equals("name"))
			ele= driver.findElement(By.name(locatorvalue));
		
		else if(locator.equals("classname"))
			ele= driver.findElement(By.className(locatorvalue));
		
		else if(locator.equals("linktext"))
			ele= driver.findElement(By.linkText(locatorvalue));
		
		else if(locator.equals("tagname"))
			ele=driver.findElement(By.tagName(locatorvalue));
		
		else if(locator.equals("xpath"))
			ele= driver.findElement(By.xpath(locatorvalue));
		
		} catch (Exception e) {
			Log.Error("Element '"+element + "' by "+locator +" : "+locatorvalue+ " is not found");
			//Assert.fail("Element '"+element + "' by "+locator +" : "+locatorvalue+ " is not found");
			}
	   return ele;
		
	}
	
	// Original one.
	/*public WebElement getElement(String element, String locator, String locatorvalue) throws Exception 
	{
		try {
		if(locator.equals("id"))
		return driver.findElement(By.id(locatorvalue));
		else if(locator.equals("name"))
			return driver.findElement(By.name(locatorvalue));
		else if(locator.equals("classname"))
			return driver.findElement(By.className(locatorvalue));
		else if(locator.equals("linktext"))
			return driver.findElement(By.linkText(locatorvalue));
		else if(locator.equals("tagname"))
			return driver.findElement(By.tagName(locatorvalue));
		else if(locator.equals("xpath"))
			return driver.findElement(By.xpath(locatorvalue));
		else
			throw new Exception("unknown locator..'"+ locator+"'");
		} catch (Exception e) {
			Log.Error("Element '"+element + "' by "+locator +" : "+locatorvalue+ " is not found");
			return null;
		//	throw new Exception("Element '"+element + "' by "+locator +":"+locatorvalue+ " is not found");
		}
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
