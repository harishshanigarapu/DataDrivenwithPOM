package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase 
{

	LoginPage LP;
	HomePage HP;
	ContactsPage CTP;
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
	super();	
	}
	
	@BeforeMethod
	public void setUp()
	{
	Initialization();
	LP = new LoginPage();
	CTP = new ContactsPage();
	HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
	HP.clickonContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsPageTest()
	{
		CTP.VerifyContactsPage();	
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String fname, String lname, String mail)
	{
	CTP.clickonNewContact();
	//CTP.CreateContact("Hari", "Shanigar", "harishkum@gmail.com");
	CTP.CreateContact(fname, lname, mail);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();	
	}
}