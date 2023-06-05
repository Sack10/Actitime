package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.Loginpage;

public class Baseclass {
	 FileLibrary f1 = new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("Database connected",true);
	}
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actitimeurl1 = f1.readdatafrompropertyfile("url");
		driver.get("actitimeurl1");
		Reporter.log("Browser launched",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		Loginpage lp = new Loginpage(driver);
		String un = f1.readdatafrompropertyfile("username");
		String pw = f1.readdatafrompropertyfile("password");
		lp.getUntbx().sendKeys("un");
		lp.getLgbtn().sendKeys("pwd");
		Reporter.log("Logged in to actitime",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out successfully",true);
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	@AfterSuite
	public void closedatabaseConnection() {
		Reporter.log("database disconnected",true);
	}
	}

