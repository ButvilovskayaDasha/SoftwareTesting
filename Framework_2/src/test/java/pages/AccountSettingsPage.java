package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage extends AbstractPage {

    private final String BASE_URL = "https://www.ryanair.com/gb/en/account/settings";

    @FindBy(xpath = "//a[@id='changePasswordAnchor']")
    private WebElement linkChangePassword;

    @FindBy(xpath = "//input[@id='oldPassword']")
    private WebElement inputOldPassword;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement inputNewPassword;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//no-captcha[@g-recaptcha-response='$ctrl.changePassword.captchaResponse']")
    private WebElement captcha;

    public AccountSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public void changePassword(String oldPassword, String newPassword) {
        linkChangePassword.click();
        inputOldPassword.sendKeys(oldPassword);
        inputNewPassword.sendKeys(newPassword);
        inputConfirmPassword.sendKeys(newPassword);
    }

    public boolean checkCaptcha() {
        return driver.findElements(By.xpath("//no-captcha[@g-recaptcha-response='$ctrl.changePassword.captchaResponse']")).size() > 0;
    }
}
