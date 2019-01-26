package Framework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeSuite
	public void object_repo() throws Exception
	{
		
	}
	
	@BeforeClass
	public void beforeclass()
	{
		Log.Info("****************** Test Execution started ******************");
	}
	
	@AfterClass
	public void afterclass()
	{
		Log.Info("****************** Test Execution completed ****************");
	}
}
