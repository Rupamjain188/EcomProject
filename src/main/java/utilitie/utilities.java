package utilitie;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Replace;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilities 
{
	private static final String[][] Object = null;


	public static String RandomInput()
	{

		Date date=new Date(0);

         String timeStem= date.toString().replace(" "," ").replace(":","_");
         return "rahul"+timeStem+"@gmail.com";
	}

	
    public static Object[][] GetTtestDataFromExel(String sheetName)
    { 
     	
    	File exalfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mywebsite\\testdata\\WebsiteProject.xlsx");
   	
   XSSFWorkbook workbook = null;
   	 	
   	 	
    	try {
	     	FileInputStream inputstrem=new FileInputStream(exalfile);
	 	    workbook=new XSSFWorkbook(inputstrem);
		} catch (Throwable e) {
		  e.printStackTrace();
		}
    	
   
   XSSFSheet sheet=workbook.getSheet(sheetName);
    	
    	int rows=sheet.getLastRowNum();
    	int coloums=sheet.getRow(0).getLastCellNum();
    	
    	Object [][] data=new Object[rows][coloums];
    	
    for (int i = 0; i < rows; i++) 
    {
    	 XSSFRow row=sheet.getRow(i+1);
    	 
    	  for (int j = 0; j < coloums; j++) 
    	  {
    		  XSSFCell cell = row.getCell(j);
    		  CellType cellType = cell.getCellType();
    		  
    		  switch (cellType)
    		  {
			case STRING:
			
				data[i][j]=cell.getStringCellValue();
				break;
			
			
			case NUMERIC:
		
				data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				break;	 		  
			
		   }
    	 
    	 
		
    	  }
    	  }
    
      return data;
    }
}
    	
	


