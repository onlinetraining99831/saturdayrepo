package Framework;

import org.apache.log4j.Logger;

public class Log {
 
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void StartTestCase(String Testname)
	{
		Log.info("Starting Test for "+Testname);
	}
	
	public static void EndTestCase(String Testname)
	{
		Log.info("Ending Test for "+Testname);
	}
	
	public static void Info(String message)
	{
		Log.info(message);
	}
	
	public static void Warn(String message)
	{
		Log.warn(message);
	}
	public static void Error(String message)
	{
		Log.error(message);
	}
}
