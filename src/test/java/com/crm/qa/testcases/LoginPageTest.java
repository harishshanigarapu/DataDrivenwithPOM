package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	
LoginPage LP;
HomePage HP;

public LoginPageTest()
{
super();	
}

@BeforeMethod
public void setUp()
{
Initialization();
LP = new LoginPage();
}

@Test(priority=1)
public void LoginPageTitleTest()
{
	String title = LP.ValidateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
}

@Test(priority=2)
public void ValidateCRMLogoTest()
{
	Boolean flag = LP.ValidateCRMLogo();
	Assert.assertTrue(flag);
}


@Test(priority=3)
public void LoginTest()
{
HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));	
}


@AfterMethod
public void tearDown()
{
driver.quit();	
}

}
