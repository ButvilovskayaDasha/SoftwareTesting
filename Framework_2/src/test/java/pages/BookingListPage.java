package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BookingListPage extends AbstractPage {

    private final String BASE_URL = "https://rooms.ryanair.com/gb/en/list/";

    @FindBy(xpath = "//rooms-accommodation-list[contains(@class,'accommodation-list')]/rooms-accommodation-card[1]/div/div/rooms-accommodation-card-body-desktop/div/div[2]/div[2]/div[2]/button")
    private WebElement selectedHotel;

    public BookingListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public BookingDetailsPage selectHotel() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(selectedHotel));
        selectedHotel.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new BookingDetailsPage(driver);
    }
}
