package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class fwutil {

	public static String getxl(String path, String loginsheet, int r, int c) {
		String v="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(loginsheet).getRow(r).getCell(c).toString();
		}
			catch(Exception e){
				e.printStackTrace();
			}
		return v;
		}
	
	
        public static void setxl(String resultpath, String loginsheet, int r, int c, int v) {
        	
        	try {
//        		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
//        		wb.getSheet(loginsheet).getRow(r).getCell(c).setCellValue(v);;
//        		wb.write(new FileOutputStream(path));
        		
        		Workbook wb=WorkbookFactory.create(new FileInputStream(resultpath));
        		Sheet sheet = wb.getSheet(loginsheet);
        		 Row row = sheet.createRow(r);
        		 Cell cell = row.createCell(c);
        		cell.setCellValue(v);
        		wb.write(new FileOutputStream(resultpath));
      //  		wb.close();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        
        public  static int getrowcount(String path, String loginsheet, int rcount) {
        	try {
        		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
        		rcount=wb.getSheet(loginsheet).getLastRowNum();
        	}
        	catch(Exception e) {
        		e.printStackTrace();        		
        	}
        	return rcount;
        }
	 
        public static int getcolcount(String path,String loginsheet,int r,int ccount) {
        	try {
        		Workbook wb=WorkbookFactory.create(new FileInputStream(path));
        		ccount=wb.getSheet(loginsheet).getRow(r).getLastCellNum();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	return ccount;
        }
        
        public static void getphoto(String photopath,WebDriver driver ) {
        	try {
        		TakesScreenshot t= (TakesScreenshot) driver;
        		File Src = t.getScreenshotAs(OutputType.FILE);
        		File dst=new File(photopath);
        		FileHandler.copy(Src, dst);
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
}

