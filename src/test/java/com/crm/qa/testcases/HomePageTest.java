package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
LoginPage LP;
HomePage HP;
ContactsPage CP;
CalendarPage ClP; 

	
	public HomePageTest()
	{
	super();	
	}
	
	@BeforeMethod
	public void setUp()
	{
	Initialization();
	LP = new LoginPage();
	CP = new ContactsPage();
	ClP = new CalendarPage();
	HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle = HP.verifyHomepagetitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM","HomePage Title Not Matched");
	}
	
	@Test(priority=2)
	public void verifyUserDisplayTest()
	{
		boolean flag = HP.verifyusernamedisplay();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifycalenderclickTest()
	{	
		ClP = HP.clickonCalender();
	}
	
	@Test(priority=4)
	public void verifyContactsclickTest()
	{
		 CP = HP.clickonContacts();	
	}
	
	

	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
	
}
