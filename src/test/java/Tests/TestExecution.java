package Tests;

import org.testng.annotations.Test;

import Framework.BaseClass;
import Framework.Constants;
import Framework.DriverScript;
import Framework.KeywordActions;
import Framework.Log;
import Utilities.ExcelReader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestExecution extends BaseClass {
	
	WebDriver driver;
  //@Test
  public void f() throws Exception {
	  Log.StartTestCase("First test");
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx");
	  driver.manage().window().maximize();
	  
	  KeywordActions actions = new KeywordActions(driver);
	  
	  actions.enterText("txtusername", "name", "ctl00$MainContent$username1", "Tester");
	  actions.enterText("txtpassword", "id", "ctl00_MainContent_password", "test");
	//  actions.clickButton("btnlogin", "name", "ctl00$MainContent$login_button");
	  Log.EndTestCase("First test");
  }
 // @Test
  public void test2()
  {
	  Log.StartTestCase("second test");
	  Log.Info("test2 passed.");
	  Log.EndTestCase("second test");
  }
  
 // @Test
  public void test() throws Exception
  {
	   ExcelReader OR = new ExcelReader(System.getProperty("user.dir")+Constants.OR_path);
	   ExcelReader Testdata = new ExcelReader(System.getProperty("user.dir")+Constants.TestCases_path);
	   OR.closeExcel();
	   Testdata.closeExcel();
	  //System.out.println(System.getProperty("user.dir")+Constants.OR_path);
	  
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx");
	  driver.manage().window().maximize();
	  
	  KeywordActions actions = new KeywordActions(driver);
	//  actions.enterText("username",OR.locatorof("username"),OR.locatorvalueof("username"),Testdata.getdata("username"));
	//  actions.enterText("password",OR.locatorof("password"),OR.locatorvalueof("password"), Testdata.getdata("password"));
	//  actions.clickButton("loginbutton",OR.locatorof("loginbutton"),OR.locatorvalueof("loginbutton"));

  }
  
  /*@Test
  public void testing() throws Exception
  {
	driver = new ChromeDriver();
	 driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx");
	 driver.manage().window().maximize();
	  
	  DriverScript driverscript = new DriverScript(driver);
	  DriverScript.starttest();
  }*/
  
  
  @BeforeTest
  public void before() throws Exception
  {
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx");
	  driver.manage().window().maximize();
	  DriverScript driverscript = new DriverScript(driver);
	  DriverScript.initiate();
  }
  
  @BeforeMethod
  public void beforemethod()
  {
	  driver = new ChromeDriver();
	  driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx");
	  driver.manage().window().maximize();
  }
  
  
  @Test(dataProvider="gettestcasename")
  public void execute_tests(String testname) throws Exception
  {
	  DriverScript.starttest(testname);
  }
  
  @AfterMethod
  public void after()
  {
	  driver.quit();
  }
  
  @DataProvider(name="gettestcasename")
  public Object[][] gettestname()
  {
	  
	  Object[][] testnames = new Object[DriverScript.testcases.size()][1];
	  ArrayList<String> TestCases=DriverScript.reader.get_TC_list_to_execute();
	  for(int i=0; i<DriverScript.testcases.size(); i++)
	  {
		  testnames[i][0] = TestCases.get(i).toString();
		  System.out.println(testnames[i][0]);
	  }
	  return testnames;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
