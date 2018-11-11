import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//*[@id=\"myryanair-auth-signup\"]")
    private WebElement signUpIcon;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SignUpWindow click() {
        signUpIcon.click();
        return new SignUpWindow(driver);
    }
}
