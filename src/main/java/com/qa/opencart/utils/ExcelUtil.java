package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	private static String TEST_DATA_SHEET_PATH="./src/test/resource/Book2.xlsx";
	private static Workbook book;
	private static org.apache.poi.ss.usermodel.Sheet sh;
	public static Object[][]getTestData(String sn)
	{
		System.out.println("readind sheet");
		Object data[][]=null;
		FileInputStream ip;
		try {
			ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			try {
				book=WorkbookFactory.create(ip);
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sh=book.getSheet(sn);
			data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
			for(int i=0;i<sh.getLastRowNum();i++)
			{
				for (int j=0;j<sh.getRow(0).getLastCellNum();j++) {
					data[i][j]=sh.getRow(i+1).getCell(j).toString();
				
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
}

