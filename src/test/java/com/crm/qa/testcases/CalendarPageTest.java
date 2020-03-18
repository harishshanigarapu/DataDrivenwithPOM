package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CalendarPageTest extends TestBase
{
	LoginPage LP;
	HomePage HP;
	CalendarPage ClP;
	
	public CalendarPageTest()
	{
	super();	
	}
	
	@BeforeMethod
	public void setUp()
	{
	Initialization();
	LP = new LoginPage();
	ClP = new CalendarPage();
	HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyCalendarPageTest()
	{	
		HP.clickonCalender();
		ClP.VerifyCalendarPage();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
}
