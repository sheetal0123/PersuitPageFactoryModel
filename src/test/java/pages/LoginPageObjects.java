package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver driver;

	@FindBy(xpath = "//form[@id='login-form']/h2")
	public WebElement logo;

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	// @FindBy(id="submit")
	// @FindBy(linkText="Sign In")
	@FindBy(xpath = "//button[@id='submit']/span")
	WebElement signInButton;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public HomePageObjects login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signInButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().refresh();
		return PageFactory.initElements(driver, HomePageObjects.class);
	}

}
