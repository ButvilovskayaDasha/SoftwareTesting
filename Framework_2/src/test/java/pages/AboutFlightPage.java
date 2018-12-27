package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutFlightPage extends AbstractPage {

    private final String BASE_URL = "https://www.ryanair.com/gb/en/booking/home/";

    @FindBy(xpath = "//span[contains(@class,'starting-point')]")
    private WebElement spanStartPoint;

    @FindBy(xpath = "//span[contains(@class,'destination')]")
    private WebElement spanDestination;

    public AboutFlightPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public boolean checkPoints(String startPoint, String destination) {
        return spanStartPoint.getAttribute("textContent").equals(startPoint) && spanDestination.getAttribute("textContent").equals(destination);
    }
}