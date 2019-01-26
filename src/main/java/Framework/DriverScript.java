package Framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Utilities.ExcelReader;

public class DriverScript {

	static WebDriver driver;
	public static ExcelReader reader;
	public static ExcelReader OR;
	public static KeywordActions actions;
	static String page;
	static String keyword;
	static String element;
	static String testdata;
	static Method[] method;
	
	static String runmode;
	
	static boolean result;
	static String testcasename;
	static int teststepno;
	
	public static ArrayList<String> testcases;
	
	public DriverScript(WebDriver driver)
	{
		this.driver=driver;
		method=KeywordActions.class.getMethods();
	}
	
	/*static public void starttest() throws Exception  // ORIGINAL
	{
		 reader = new ExcelReader(Constants.TestCases_path);
		 OR = new ExcelReader(Constants.OR_path);
		 actions = new KeywordActions(driver);
		
		String sheet = "TC_001";
		int totalteststeps = reader.getnoofrows(sheet);
		
		for(int teststep=1; teststep<=totalteststeps; teststep++)
		{
			page= reader.getcelldata(sheet, teststep, Constants.page);
			keyword = reader.getcelldata(sheet, teststep, Constants.keyword);
			element = reader.getcelldata(sheet, teststep, Constants.webelement);
			testdata = reader.getcelldata(sheet, teststep, Constants.testdata);
			//System.out.println(page+"-"+keyword+"-"+element+"-"+testdata);
			execute_action();
		}

		HashSet<String> pages = reader.getcoldata(sheet, totalteststeps, Constants.page);
		
		for (String page : pages) {
			
			System.out.println(page);
		}
	}*/
	
	static public void starttest_Original() throws Exception
	{
		 reader = new ExcelReader(Constants.TestCases_path);
		 OR = new ExcelReader(Constants.OR_path);
		 actions = new KeywordActions(driver);
		 
		 ArrayList<String> testcases =reader.get_TC_list_to_execute();
		 System.out.println("Total no. of test cases are "+testcases.size());
		
			 
			 for (int testcase = 1; testcase <= testcases.size(); testcase++)
			 {
				 try {
				 	testcasename = testcases.get(testcase-1);
				 	System.out.println("*********************************************************");
				 	System.out.println("Starting test for "+testcasename);
				 	System.out.println("*********************************************************");
					int totalteststeps = reader.getnoofrows(testcasename);
					
						for(int teststep=1; teststep<=totalteststeps; teststep++)
						{
							teststepno=teststep;
							page= reader.getcelldata(testcasename, teststep, Constants.page);
							keyword = reader.getcelldata(testcasename, teststep, Constants.keyword);
							element = reader.getcelldata(testcasename, teststep, Constants.webelement);
							testdata = reader.getcelldata(testcasename, teststep, Constants.testdata);
							//System.out.println(page+"-"+keyword+"-"+element+"-"+testdata);
							execute_action();
							
						}
				 	}
					catch (Exception e) {
						if(result==false) // if keyword fails this will execute...
						{
							Log.Info("Step "+ teststepno+"--"+"Fail");
							//break;
						}
						
					}
				 	finally
				 	{
				 		if(result==false) // If test step pass / fails then this gets executed.
						{
							Log.Info(testcasename+"--"+"Fail");
							//break;
						}
						else
						{
							Log.Info(testcasename+"--"+"Pass");
							//break;
						}
				 		System.out.println("*********************************************************");
				 		System.out.println("Ending test for "+testcasename);
				 		
				 	}
				 }
		 	}
		 	
	
	
		/*HashSet<String> pages = reader.getcoldata(sheet, totalteststeps, Constants.page);
		
		for (String page : pages) {
			
			System.out.println(page);
		}*/
	
	public static void execute_action() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
	   
		for(int i=0; i<method.length; i++)
		{
			result = true;
			if(method[i].getName().equals(keyword))
			{
				//String element, String locator, String locatorvalue, String text
				System.out.println(element+"-"+OR.locatorof(page, element)+"-"+OR.locatorvalueof(page, element)+"-"+testdata);
				method[i].invoke(actions, element,OR.locatorof(page, element),OR.locatorvalueof(page, element),testdata);
				
				if(result==false) // If test step pass / fails then this gets executed.
				{
					Log.Info("Step "+teststepno+"--"+"Fail");
					break;
				}
				else
				{
					Log.Info("Step "+teststepno+"--"+"Pass");
					break;
				}
				
			}
		}
	}
	
	 //***************************************************************************************
	
	static public void initiate() throws Exception
	{
		reader = new ExcelReader(Constants.TestCases_path);
		OR = new ExcelReader(Constants.OR_path);
		actions = new KeywordActions(driver);
		testcases =reader.get_TC_list_to_execute();
	}
	
	
	static public void starttest(String testcasename) throws Exception
	{
		/* reader = new ExcelReader(Constants.TestCases_path);
		 OR = new ExcelReader(Constants.OR_path);
		 actions = new KeywordActions(driver);
		 
		testcases =reader.get_TC_list_to_execute();*/
		 System.out.println("Total no. of test cases are "+testcases.size());
		 try {
			 	//testcasename = testcases.get(testcase-1);
			 	System.out.println("*********************************************************");
			 	System.out.println("Starting test for "+testcasename);
			 	System.out.println("*********************************************************");
				int totalteststeps = reader.getnoofrows(testcasename);
				
					for(int teststep=1; teststep<=totalteststeps; teststep++)
					{
						teststepno=teststep;
						page= reader.getcelldata(testcasename, teststep, Constants.page);
						keyword = reader.getcelldata(testcasename, teststep, Constants.keyword);
						element = reader.getcelldata(testcasename, teststep, Constants.webelement);
						testdata = reader.getcelldata(testcasename, teststep, Constants.testdata);
						//System.out.println(page+"-"+keyword+"-"+element+"-"+testdata);
						execute_action();
						
					}
			 	}
		 catch (Exception e) {
				if(result==false) // if keyword fails this will execute...
				{
					Log.Info("Step "+ teststepno+"--"+"Fail");
					//break;
				}
				
			}
		 	finally
		 	{
		 		if(result==false) // If test step pass / fails then this gets executed.
				{
					Log.Info(testcasename+"--"+"Fail");
					//break;
				}
				else
				{
					Log.Info(testcasename+"--"+"Pass");
					//break;
				}
		 		System.out.println("*********************************************************");
		 		System.out.println("Ending test for "+testcasename);
		 		
		 	}
	}
	
	
} // cass closing
	
	

