package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SelectCarsPage extends AbstractPage {

    private final String BASE_URL = "https://car-hire.ryanair.com/en-gb/book";

    @FindBy(xpath = "//div[contains(@id,'ct-availability-list')]/div[2]/ct-vehicle-block/div/div/div/div/div[2]/div[4]/ct-vehicle-block-buttons/button[1]")
    private WebElement carSelectButton;

    @FindBy(xpath = "//button[@ng-click='buttonBookNow()']")
    private WebElement carBokNowButton;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement inputFirstname;

    @FindBy(xpath = "//*[@id=\"surname\"]")
    private WebElement inputSurname;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement inputAddress;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement inputCity;

    @FindBy(xpath = "//button[@ng-click='confirm()']")
    private WebElement confirmButton;

    public SelectCarsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public void clickToSelectCar() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carSelectButton));
        carSelectButton.click();
    }

    public void clickToContinueSelectCar() {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(carBokNowButton));
        carBokNowButton.click();
    }


    public void fillInformation(String firstname, String surname, String email, String address, String city) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputFirstname));
        inputFirstname.sendKeys(firstname);
        inputSurname.sendKeys(surname);
        inputEmail.sendKeys(email);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
    }

    public boolean containsError() {
        confirmButton.click();
        return driver.findElements(By.xpath("//span[@data-tooltip='Please fill in your phone number.']")).size() > 0;
    }

}

