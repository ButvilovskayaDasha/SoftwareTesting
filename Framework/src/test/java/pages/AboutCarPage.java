package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutCarPage extends AbstractPage {

    @FindBy(xpath = "//button[@ng-click='buttonBookNow()']")
    private WebElement carSelectButton;

    public AboutCarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ContactInfoPage clickToContinueSelectCar() {
        carSelectButton.click();
        return new ContactInfoPage(driver);
    }
}
