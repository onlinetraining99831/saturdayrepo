package Framework;

import org.openqa.selenium.WebDriver;

public class CommonFunctions {
	
	WebDriver driver;
	
	public void navigateTo(String url)
	{
		driver.get(url);
	}
	
	public void goBack()
	{
		driver.navigate().back();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void quitBrowsers()
	{
		driver.quit();
	}
}
