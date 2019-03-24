package com.tests.sample3_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.artos.annotation.AfterTestUnit;
import com.artos.annotation.BeforeTestUnit;
import com.artos.annotation.TestCase;
import com.artos.annotation.TestPlan;
import com.artos.annotation.Unit;
import com.artos.framework.infra.TestContext;
import com.artos.interfaces.TestExecutable;

@TestPlan(preparedBy = "arpit", preparationDate = "6/03/2019", bdd = "GIVEN Firefox browser is installed AND 64bit drivers located in assets directory are valid for installed version of firefox THEN current test cases should launch browser and open www.theartos.com webpage")
@TestCase
public class Sample_Selenium implements TestExecutable {

	@Unit
	public void testUnit_1(TestContext context) throws Exception {
		// --------------------------------------------------------------------------------------------
		WebDriver fireFoxDriver = (WebDriver) context.getGlobalObject("FIREFOX_DRIVER");
		// fireFoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fireFoxDriver.navigate().to("https://www.theartos.com");
		Thread.sleep(5000);
		// --------------------------------------------------------------------------------------------
	}

	@BeforeTestUnit
	public void beforeTest(TestContext context) {
		System.setProperty("webdriver.gecko.driver", "./assets/driver/geckodriver_64bit.exe");
		WebDriver firefoxDriver = new FirefoxDriver();
		firefoxDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		context.setGlobalObject("FIREFOX_DRIVER", firefoxDriver);

		// System.setProperty("webdriver.chrome.driver",
		// "./assets/driver/chromedriverwin32.exe");
		// WebDriver chromeDriver = new ChromeDriver();
		// context.setGlobalObject("CHROME_DRIVER", chromeDriver);
	}

	@AfterTestUnit
	public void tearDown(TestContext context) {
		WebDriver fireFoxDriver = (WebDriver) context.getGlobalObject("FIREFOX_DRIVER");
		fireFoxDriver.quit();

		// WebDriver chromeDriver = (WebDriver)
		// context.getGlobalObject("CHROME_DRIVER");
		// chromeDriver.quit();
	}

}
