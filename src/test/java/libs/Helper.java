package libs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {

	public String server, loginUser, loginPassword, drv;
	public Properties prop;
	public WebDriver driver;

	public void getProperties() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(
					"C:\\Users\\sheetalsingh\\workspace\\PersuitPageFactoryModel\\src\\test\\resources\\persuit.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		server = prop.getProperty("SERVER");
		drv = prop.getProperty("DRIVER");
		loginUser = prop.getProperty("LOGIN_USER");
		loginPassword = prop.getProperty("LOGIN_PASSWORD");

	}

	public WebDriver getDriver() {
		if (drv.equals("firefox")) {
			return new FirefoxDriver();
		} else if (drv.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/xebia/Downloads/jars/chromedriver");
			return new ChromeDriver();
		} else {
			System.out.println("Invalid driver");
			return null;
		}
	}

	public WebDriver getDriver(String cmdDriver) {
		if (cmdDriver.equals("firefox")) {
			return new FirefoxDriver();
		} else if (cmdDriver.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/home/xebia/Downloads/jars/chromedriver");
			return new ChromeDriver();
		} else {
			System.out.println("Invalid driver");
			return null;
		}
	}

}
