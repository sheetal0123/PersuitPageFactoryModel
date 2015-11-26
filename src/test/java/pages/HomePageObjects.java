package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	WebDriver driver;

	@FindBy(xpath = "//h1[text()='PERSUIT home']")
	public WebElement homepageText;

	@FindBy(xpath = "//li[@class='dropdown']/div/button")
	WebElement userDisplayNameArrow;

//	@FindBy(linkText = "Logout")
	@FindBy(xpath="//li[@class='dropdown']/div/div/button")
	WebElement logoutButton;

	@FindBy(linkText = "Opportunities")
	WebElement opportunitiesTab;

	@FindBy(linkText = "Profiles")
	WebElement profilesTab;

	@FindBy(linkText = "Settings")
	WebElement settingsTab;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public OpportunitiesPageObjects selectOpportunitiesTab() {
		opportunitiesTab.click();
		return PageFactory.initElements(driver, OpportunitiesPageObjects.class);
	}

	public ProfilesPageObjects selectProfilesTab() {
		profilesTab.click();
		return PageFactory.initElements(driver, ProfilesPageObjects.class);
	}

	public SettingsPageObjects selectSettingTab() {
		settingsTab.click();
		return PageFactory.initElements(driver, SettingsPageObjects.class);
	}

	public LoginPageObjects logout() {
		userDisplayNameArrow.click();
		logoutButton.click();
		return PageFactory.initElements(driver, LoginPageObjects.class);

	}
}