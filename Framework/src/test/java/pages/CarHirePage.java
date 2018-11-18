package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHirePage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"core-input ng-pristine ng-untouched ng-valid ng-empty\"]")
    private WebElement inputCity;

    @FindBy(xpath = "//div[contains(@class,'core-list')]/div[2]/ng-transclude/div/div[1]")
    private WebElement selectCityFromList;

    @FindBy(xpath = "//input[@aria-label='Pick up date: - DD']")
    private WebElement inputPickUpDay;

    @FindBy(xpath = "//input[@aria-label='Pick up date: - MM']")
    private WebElement inputPickUpMonth;

    @FindBy(xpath = "//input[@aria-label='Pick up date: - YYYY']")
    private WebElement inputPickUpYear;

    @FindBy(xpath = "//input[@aria-label='Drop off date: - DD']")
    private WebElement inputDropOffDay;

    @FindBy(xpath = "//input[@aria-label='Drop off date: - MM']")
    private WebElement inputDropOffMonth;

    @FindBy(xpath = "//input[@aria-label='Drop off date: - YYYY']")
    private WebElement inputDropOffYear;

    @FindBy(xpath = "//*[@class=\"core-btn-primary core-btn-block core-btn-big\"]")
    private WebElement letsGoButton;

    public CarHirePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void fillInformation(String city, String pickUpDay, String pickUpMonth, String pickUpYear, String dropOffDay, String dropOffMonth, String dropOffYear) {
        inputCity.sendKeys(city);
        selectCityFromList.click();
        inputPickUpDay.sendKeys(pickUpDay);
        inputPickUpMonth.sendKeys(pickUpMonth);
        inputPickUpYear.sendKeys(pickUpYear);
        inputDropOffDay.sendKeys(dropOffDay);
        inputDropOffMonth.sendKeys(dropOffMonth);
        inputDropOffYear.sendKeys(dropOffYear);
    }

    public SelectCarsPage clickOnSelectCars() {
        letsGoButton.click();
        return new SelectCarsPage(driver);
    }
}
