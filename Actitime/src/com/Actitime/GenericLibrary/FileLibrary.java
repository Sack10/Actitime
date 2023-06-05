package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is generic class is contains all the generic method.
 * @author sakha
 *
 */
public class FileLibrary {
	/**
	 * this method is a generic method which is used to read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
		public String readdatafrompropertyfile(String key) throws IOException  {
			FileInputStream fis = new FileInputStream("./Testdata/commandata.property");
			Properties p = new Properties();
			p.load(fis);
			String Value = p.getProperty("key");
			return Value;
}
		/**
		 * this method is a generic method which is used to read data from excel sheet.
		 * @param sheetname
		 * @param row
		 * @param cell
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String readdatafromexcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis= new FileInputStream("./Testdata/Testdata1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
			return value;
		}
}
