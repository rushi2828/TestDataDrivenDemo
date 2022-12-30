package com.qa.Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Base.TestBase;


public class LoginPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	Actions action = new Actions(driver);

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Your Email Address']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement password;

	@FindBy(xpath = "//a[contains(text(),'log in')]")
	WebElement loginButton;
}
