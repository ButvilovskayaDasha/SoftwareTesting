import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SignUpWindow extends AbstractPage{

    @FindBy(xpath = "//*[@id=\"email308\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"password325\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@class=\"core-btn-primary\"]")
    private WebElement signUpButton;

    public SignUpWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void fill(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        signUpButton.click();
    }

    public boolean containsError() {
        return driver.findElements(By.xpath("//*[@class=\"error\"]")).size() > 0;
    }
}
