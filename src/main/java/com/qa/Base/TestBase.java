package com.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.Utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties properties;

	public TestBase() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
		properties.load(fis);
	}

	public static void initialisation(String browserName) {
		if (browserName == "chrome") {
			WebDriverManager.chromedriver().setup();
		} else if (browserName == "firefox") {
			WebDriverManager.firefoxdriver().setup();
		} else if (browserName == "safari") {
			WebDriverManager.safaridriver().setup();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));
	}

}
