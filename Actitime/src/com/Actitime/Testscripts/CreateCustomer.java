package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.Pom.Homepage;
import com.Actitime.Pom.TaskPage;

public class CreateCustomer extends Baseclass {

	@Test
	public void Createcustomer() throws EncryptedDocumentException, IOException {
		 Homepage hp = new Homepage(driver);
		 hp.getTasktab().click();
		 TaskPage tp = new TaskPage(driver);
		 tp.getAddnewbtn().click();
		 tp.getNewcust().click();
		 FileLibrary f1 = new FileLibrary();
		 String customer = f1.readdatafromexcel("data", 4, 2);
		 tp.getCustname().sendKeys("custmor");
		 String description = f1.readdatafromexcel("data", 4, 2);
		 tp.getCustdesp().sendKeys("description");
		 tp.getCreatebtn().click();
		 String expectedresult = customer;
		   actualresult = driver.findElement(By.xpath(""));
				  SoftAssert s= new SoftAssert();
		  s.assertEquals(false, false);
				 
		 
		 
		
}
}