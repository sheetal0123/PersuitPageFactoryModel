package testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import libs.Helper;
import pages.HomePageObjects;
import pages.LoginPageObjects;
import pages.OpportunitiesPageObjects;
import pages.ProfilesPageObjects;
import pages.SettingsPageObjects;

public class Testcases {

	WebDriver driver;
	Helper helper;

	HomePageObjects homepage;
	LoginPageObjects loginpage;
	OpportunitiesPageObjects opportunitiespage;
	ProfilesPageObjects profilespage;
	SettingsPageObjects settingspage;

	String cmdDriver;

	@BeforeClass
	public void setup() {
		helper = new Helper();
		helper.getProperties(); // driver from property file
		cmdDriver = System.getProperty("driver"); // driver from cmd
		if (cmdDriver != null && !cmdDriver.trim().isEmpty()) {
			driver = helper.getDriver(cmdDriver);
		} else {
			driver = helper.getDriver();
		}

		System.out.println("Cmd driver: " + cmdDriver);
		System.out.println("Property default driver: " + helper.drv);
		System.out.println("Driver selected:" + driver);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLogin() {
		driver.get(helper.server);
		loginpage = PageFactory.initElements(driver, LoginPageObjects.class);
		homepage = loginpage.login(helper.loginUser, helper.loginPassword);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElements(By.xpath("//h1[text()='PERSUIT home']")).size() > 0);
		
	}

	@Test(dependsOnMethods = { "verifyLogin" })
	public void verifyLogout() {
		loginpage = homepage.logout();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(loginpage.logo.getText(), "PERSUIT");
	}



}
