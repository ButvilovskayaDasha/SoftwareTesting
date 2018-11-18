package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    private final String BASE_URL = "https://www.ryanair.com/gb/en/";

    @FindBy(xpath = "//*[@id=\"tab-cars-text\"]")
    private WebElement carHireTab;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CarHirePage clickOnCarHireTab() {
        carHireTab.click();
        return new CarHirePage(driver);
    }

    public void openPage() {
        driver.navigate().to(BASE_URL);
    }
}
