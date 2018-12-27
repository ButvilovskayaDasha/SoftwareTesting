package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingDetailsPage extends AbstractPage {

    private final String BASE_URL = "https://rooms.ryanair.com/gb/en/details/";

    @FindBy(xpath = "//button[@class='room-card__book-button ry-button--gradient-blue ry-button']")
    private WebElement buttonBookNow;

    public BookingDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public PaymentPage bookApartments() {
        buttonBookNow.click();
        return new PaymentPage(driver);
    }
}
