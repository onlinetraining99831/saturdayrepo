package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Framework.Constants;

public class ExcelReader {
	
	public FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet ws;
	public  XSSFRow row;
	public  XSSFCell cell;

	//Load excel through constructor.
	public ExcelReader(String filepath) throws IOException
	{
		fi=new FileInputStream(filepath);
		wb = new XSSFWorkbook(fi);
	}
	/*public static void loadExcel(String filepath) throws Exception
	{
		fi=new FileInputStream(filepath);
		wb = new XSSFWorkbook(fi);
	}*/
	
	
	public  int getnoofrows(String worksheet)
	{
		ws=wb.getSheet(worksheet);
		//System.out.println("No. of rows are "+ws.getLastRowNum());
		return ws.getLastRowNum();
	}
	
	public  int getnoofcolumns(String worksheet)
	{
		ws=wb.getSheet(worksheet);
		row=ws.getRow(0);
		//System.out.println("No. of cols are " +row.getLastCellNum());
		return row.getLastCellNum();
	}
	
	public  void closeExcel() throws IOException
	{
		wb.close();
	}
	
/*	public HashMap<String, String> getrepository(String worksheet)
	{
		HashMap<String, String> repo = new HashMap<String, String>();
		int lastrow = getnoofrows(worksheet);
		for(int row=1; row<lastrow; row++)
		{
			repo.put(ws.getRow(row).getCell(0).toString(), ws.getRow(row).getCell(3).getStringCellValue());
			System.out.println(ws.getRow(row).getCell(0).toString()+"--"+ ws.getRow(row).getCell(3).getStringCellValue());
		}
		return repo;
		
	}*/
	
	public  String[][] getrepo(String worksheet)
	{
		int totalrows = getnoofrows(worksheet);
		int totalcols = getnoofcolumns(worksheet);
		String[][] repo = new String[totalrows][totalcols];
		
		for(int rowno=1; rowno<=totalrows; rowno++)
		{
			row=ws.getRow(rowno);
			for(int colno=0; colno<totalcols; colno++)// 0<3, 1<3, 2<3
			{
				repo[rowno-1][colno]=row.getCell(colno).toString(); //
				//System.out.print(repo[rowno-1][colno]+" ");
			}
			//System.out.println("");
		}
		return repo;
	}
	
	public String locatorof(String elementname)
	{
		int totalrows = getnoofrows("LoginPage");
		String[][] data=getrepo("LoginPage");
		String locator="";
		for(int row=0; row<totalrows; row++)
		{
			if(data[row][0].equals(elementname))
			{
				 locator=data[row][1].toString();
				 System.out.print(locator+" ");
				 break;
			}
		}
		return locator;
	}
	
	public String locatorvalueof(String elementname)
	{
		int totalrows = getnoofrows("LoginPage");
		String[][] data=getrepo("LoginPage");
		String locatorvalue="";
		for(int row=0; row<totalrows; row++)
		{
			if(data[row][0].equals(elementname))
			{
				locatorvalue=data[row][2].toString();
				 System.out.print(locatorvalue+" ");
				 break;
			}
		}
		return locatorvalue;
	}
	
	public String getdata(String elementname)
	{
		int totalrows = getnoofrows("TC_001");
		String[][] data=getrepo("TC_001");
		String testdata="";
		for(int row=0; row<totalrows; row++)
		{
			if(data[row][3].equals(elementname))
			{
				testdata=data[row][4].toString();
				 System.out.print(testdata+" ");
				 break;
			}
		}
		return testdata;
	}
	
	public String getcelldata(String sheet,int rowno, int colno)
	{
		row=ws.getRow(rowno);
		return row.getCell(colno).getStringCellValue();
	}
	
	public HashSet<String> getcoldata(String sheet, int rowno, int colno) throws Exception
	{
		HashSet<String> data = new HashSet<String>();
		for(int rows=1; rows<=rowno; rows++)
		{
			row = ws.getRow(rows);
			if(!row.getCell(colno).getStringCellValue().toString().isEmpty())
				data.add(row.getCell(colno).getStringCellValue().toString());
		}
		closeExcel();
		return data;
	}
	
	public String locatorof(String page, String elementname)
	{
		int totalrows = getnoofrows(page);
		String[][] data=getrepo(page);
		String locator="";
		for(int row=0; row<totalrows; row++)
		{
			if(data[row][0].equals(elementname))
			{
				 locator=data[row][1].toString();
				 //System.out.print(locator+" ");
				 break;
			}
		}
		return locator;
	}
	public String locatorvalueof(String page, String elementname)
	{
		int totalrows = getnoofrows(page);
		String[][] data=getrepo(page);
		String locatorvalue="";
		for(int row=0; row<totalrows; row++)
		{
			if(data[row][0].equals(elementname))
			{
				locatorvalue=data[row][2].toString();
				 //System.out.print(locatorvalue+" ");
				 break;
			}
		}
		return locatorvalue;
	}
	
	public ArrayList<String> get_TC_list_to_execute()
	{
		ArrayList<String> list = new ArrayList<String>();
		int totaltestcases = getnoofrows("Testcases");
		 for(int testcase=1; testcase<=totaltestcases; testcase++)
		 {
			 row=ws.getRow(testcase);
			 if(row.getCell(Constants.runmode).getStringCellValue().toString().equals("Y"))
				 list.add(row.getCell(Constants.testcaseid).getStringCellValue().toString());
		 }
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
