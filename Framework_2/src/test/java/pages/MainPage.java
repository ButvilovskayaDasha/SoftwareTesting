package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://www.ryanair.com/gb/en/";
    private final String GERMAN_URL = "https://www.ryanair.com/de/de/";

    @FindBy(xpath = "//*[@id=\"myryanair-auth-signup\"]")
    private WebElement signUpIcon;

    @FindBy(xpath = "//*[@id=\"myryanair-auth-login\"]")
    private WebElement loginIcon;

    @FindBy(xpath = "//input[@placeholder='Departure airport']")
    private WebElement inputFromAirport;

    @FindBy(xpath = "//input[@placeholder='Destination airport']")
    private WebElement inputToAirport;

    @FindBy(xpath = "//input[@aria-label='Fly out: - DD']")
    private WebElement inputFlyOutDay;

    @FindBy(xpath = "//input[@aria-label='Fly out: - MM']")
    private WebElement inputFlyOutMonth;

    @FindBy(xpath = "//input[@aria-label='Fly out: - YYYY']")
    private WebElement inputFlyOutYear;

    @FindBy(xpath = "//input[@aria-label='Fly back: - DD']")
    private WebElement inputFlyBackDay;

    @FindBy(xpath = "//input[@aria-label='Fly back: - MM']")
    private WebElement inputFlyBackMonth;

    @FindBy(xpath = "//input[@aria-label='Fly back: - YYYY']")
    private WebElement inputFlyBackYear;

    @FindBy(xpath = "//a[@href='/gb/en/header/markets']")
    private WebElement aChangeLanguage;

    @FindBy(xpath = "//div[contains(@class,'country-list')]/div[2]/ul/li[4]/a")
    private WebElement aLanguageSelect;

    @FindBy(xpath = "//div[@class='dropdown-handle']")
    private WebElement dropdownPassengersCount;

    @FindBy(xpath = "//div[contains(@class,'last')]/div/div[3]/core-inc-dec/button[2]")
    private WebElement buttonInfantsCount;

    @FindBy(xpath = "//button[@ng-click='confirm()']")
    private WebElement buttonConfirmInfants;

    @FindBy(xpath = "//*[@id=\"tab-hotels-text\"]")
    private WebElement roomBookingTab;

    @FindBy(xpath = "//input[@placeholder='Find me a hotel']")
    private WebElement inputDestinationCity;

    @FindBy(xpath = "//input[@aria-label='Check-in: - DD']")
    private WebElement inputCheckinDay;

    @FindBy(xpath = "//input[@aria-label='Check-in: - MM']")
    private WebElement inputCheckinMonth;

    @FindBy(xpath = "//input[@aria-label='Check-in: - YYYY']")
    private WebElement inputCheckinYear;

    @FindBy(xpath = "//input[@aria-label='Check-out: - DD']")
    private WebElement inputCheckoutDay;

    @FindBy(xpath = "//input[@aria-label='Check-out: - MM']")
    private WebElement inputCheckoutMonth;

    @FindBy(xpath = "//input[@aria-label='Check-out: - YYYY']")
    private WebElement inputCheckoutYear;

    @FindBy(xpath = "//button[@class='core-btn-primary core-btn-block core-btn-big']")
    private WebElement buttonGoToBooking;

    @FindBy(xpath = "//popup-content[contains(@class,'core-popup-content core-popup-content-searchbox popup-predictions')]/a[1]")
    private WebElement dropdownCity;

    @FindBy(xpath = "//button[@class='core-btn-primary core-btn-block core-btn-big']")
    private WebElement buttonLetsGo;

    @FindBy(xpath = "//a[@ng-click='toggleUserMenu()']")
    private WebElement userAccount;

    @FindBy(xpath = "//a[@ui-sref='account.settings']")
    private WebElement userAccountSettings;

    @FindBy(xpath = "//span[@id='tab-flights-text']")
    private WebElement tabFlights;

    @FindBy(xpath = "//*[@id=\"tab-cars-text\"]")
    private WebElement carHireTab;

    @FindBy(xpath = "//input[@data-hj-suppress='']")
    private WebElement inputEmailLogin;

    @FindBy(xpath = "//input[@ng-change='$ctrl.evaluatePasswordStrength()']")
    private WebElement inputPasswordLogin;

    @FindBy(xpath = "//*[@class=\"core-btn-primary\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//ra-toaster[@popup-id='LOGIN']")
    private WebElement loginToaster;

    @FindBy(xpath = "//li[@ng-message='validEmail']")
    private WebElement errorValidEmail;

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

    @FindBy(xpath = "//*[@id='menu-container']/ul[2]/ra-toaster[1]/div/ng-transclude/span/strong")
    private WebElement successfullyLogin;

    @FindBy(xpath = "//*[@class='core-list-item core-list-item-rounded core-list-item-error']")
    private WebElement errorSameAirport;

    @FindBy(xpath = "//*[@ng-class=\"{'shown': paxInput.showInfantsAlert}\"]")
    private WebElement infantsCountError;

    @FindBy(xpath = "//*[@class=\"core-list-item core-list-item-rounded core-list-item-error\"]")
    private WebElement errorUnrealAirport;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.get(BASE_URL);
    }

    public void signUp() {
        signUpIcon.click();
    }

    public void login() {
        loginIcon.click();
    }

    public void fillFlyInformationAirports(String fromAirport, String toAirport) {
        inputFromAirport.sendKeys(fromAirport);
        inputToAirport.sendKeys(toAirport);
        inputToAirport.sendKeys(Keys.ENTER);
    }

    public void fillFlyInformationData(String flyOutDay, String flyOutMonth,
                                       String flyOutYear, String flyBackDay, String flyBackMonth, String flyBackYear) {
        inputFlyOutDay.sendKeys(flyOutDay);
        inputFlyOutMonth.sendKeys(flyOutMonth);
        inputFlyOutYear.sendKeys(flyOutYear);
        inputFlyBackDay.sendKeys(flyBackDay);
        inputFlyBackMonth.sendKeys(flyBackMonth);
        inputFlyBackYear.sendKeys(flyBackYear);
    }

    public void setInfantsCount() {
        dropdownPassengersCount.click();
        dropdownPassengersCount.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonInfantsCount);
        buttonInfantsCount.click();
        buttonConfirmInfants.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(dropdownPassengersCount));
        dropdownPassengersCount.click();
        dropdownPassengersCount.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonInfantsCount);
        buttonInfantsCount.click();
    }

    public void changeLanguage() {
        aChangeLanguage.click();
        aLanguageSelect.click();
    }

    public void goToBooking() {
        roomBookingTab.click();
    }

    public BookingListPage fillBookingInformation(String destinationCity, String checkinDay, String checkinMonth,
                                                  String checkinYear, String checkoutDay, String checkoutMonth, String checkoutYear) {
        inputDestinationCity.sendKeys(destinationCity);
        dropdownCity.click();
        inputCheckinDay.sendKeys(checkinDay);
        inputCheckinMonth.sendKeys(checkinMonth);
        inputCheckinYear.sendKeys(checkinYear);
        inputCheckoutDay.sendKeys(checkoutDay);
        inputCheckoutMonth.sendKeys(checkoutMonth);
        inputCheckoutYear.sendKeys(checkoutYear);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(buttonGoToBooking));
        buttonGoToBooking.click();
        return new BookingListPage(driver);
    }

    public AboutFlightPage letsGo() {
        buttonLetsGo.click();
        buttonLetsGo.click();
        return new AboutFlightPage(driver);
    }


    public AccountSettingsPage settingAccount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(userAccount));
        Thread.sleep(1000);
        userAccount.click();
        wait.until(ExpectedConditions.elementToBeClickable(userAccountSettings));
        userAccountSettings.click();
        return new AccountSettingsPage(driver);
    }

    public void clickOnCarHireTab() {
        carHireTab.click();
    }

    public void fillInformationCarHire(String city, String pickUpDay, String pickUpMonth, String pickUpYear, String dropOffDay, String dropOffMonth, String dropOffYear) {
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

    public void fillLoginSignup(String emailLogin, String passwordLogin) {
        inputEmailLogin.sendKeys(emailLogin);
        inputPasswordLogin.sendKeys(passwordLogin);
        loginButton.click();
    }

    public boolean isAccount() {
        return successfullyLogin.getAttribute("textContent").equals("Hi ! You've successfully logged in.");
    }

    public boolean containsErrorSignup() {
        return driver.findElements(By.xpath("//*[@ng-message='validEmail']")).size() > 0 && errorValidEmail.getAttribute("textContent").equals("Invalid email address format");
    }

    public boolean containsErrorsSameAirport(String airport) {
        return errorSameAirport.getAttribute("textContent").equals("Sorry, we don't fly from " + airport + " to " + airport.toLowerCase());
    }

    public boolean checkLanguage() {
        return driver.getCurrentUrl().equals(GERMAN_URL) && tabFlights.getAttribute("textContent").equals("Flüge");
    }

    public boolean checkInfantsError() {
        return infantsCountError.getAttribute("textContent").equals("You can't travel with more infants than adults");
    }

    public boolean containsErrorsUnrealAirport(String airport) {
        return errorUnrealAirport.getAttribute("textContent").equals("Sorry, we don't fly to " + airport.toLowerCase());
    }
}