package com.qa.TestCases;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.LoginPage;



public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	Properties prop;

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialisation(prop.getProperty("BROWSERTYPE"));
		loginPage = new LoginPage();
	}

	@Test
	public void tc1() {
		
		System.out.println(prop.getProperty("BROWSERTYPE"));

	}

	@AfterMethod
	public void tearsDown() {
		driver.quit();
	}

}
