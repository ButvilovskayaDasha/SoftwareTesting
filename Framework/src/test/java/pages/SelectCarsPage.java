package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCarsPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@id,'ct-availability-list')]/div[2]/ct-vehicle-block/div/div/div/div/div[2]/div[4]/ct-vehicle-block-buttons/button[1]")
    private WebElement carSelectButton;

    public SelectCarsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public AboutCarPage clickToSelectCar() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carSelectButton));
        carSelectButton.click();
        return new AboutCarPage(driver);
    }
}

