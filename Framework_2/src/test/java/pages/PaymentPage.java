package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends AbstractPage {

    private final String BASE_URL = "https://rooms.ryanair.com/gb/en/payment";

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@name='firstSurname']")
    private WebElement inputFirstSurname;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@name='confirmEmail']")
    private WebElement inputConfirmEmail;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//input[@name='cardNumber']")
    private WebElement inputCardNumber;

    @FindBy(xpath = "//select[@id='cardType']")
    private WebElement selectCardType;

    @FindBy(xpath = "//option[@value='AMERICAN_EXPRESS']")
    private WebElement inputCardType;

    @FindBy(xpath = "//select[@id='month']")
    private WebElement selectCardMonth;

    @FindBy(xpath = "//option[@value='05']")
    private WebElement inputCardMonth;

    @FindBy(xpath = "//select[@id='year']")
    private WebElement selectCardYear;

    @FindBy(xpath = "//option[@value='2020']")
    private WebElement inputCardYear;

    @FindBy(xpath = "//input[@name='securityCode']")
    private WebElement inputCVV;

    @FindBy(xpath = "//input[@name='cardholderName']")
    private WebElement inputCardholderName;

    @FindBy(xpath = "//input[@name='street1']")
    private WebElement inputAddress;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement inputCity;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement inputPostcode;

    @FindBy(xpath = "//button[@class='ry-button--full payment__pay-btn ry-button--gradient-yellow ry-button']")
    private WebElement buttonPayNow;

    @FindBy(xpath = "//span[@class='r-form-field__error text-xs-regular c-error-red']")
    private WebElement spanTermError;

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public void fillCreditsForBooking(String firstName, String surname, String email,
                                      String phoneNumber, String cardNumber,
                                      String cardCVV, String cardholderName,
                                      String address, String city, String postcode) {
        inputName.sendKeys(firstName);
        inputFirstSurname.sendKeys(surname);
        inputEmail.sendKeys(email);
        inputConfirmEmail.sendKeys(email);
        inputPhone.sendKeys(phoneNumber);
        inputCardNumber.sendKeys(cardNumber);
        selectCardType.click();
        inputCardType.click();
        selectCardMonth.click();
        inputCardMonth.click();
        selectCardYear.click();
        inputCardYear.click();
        inputCVV.sendKeys(cardCVV);
        inputCardholderName.sendKeys(cardholderName);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        inputPostcode.sendKeys(postcode);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonPayNow);
        buttonPayNow.click();
    }

    public boolean checkTerm() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(spanTermError));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", spanTermError);
        return spanTermError.getAttribute("textContent").equals(" Terms & Conditions: please indicate that you have read and understand the terms and conditions to continue");
    }
}
