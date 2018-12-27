package steps;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.IOException;

import static utils.Utils.generatePassword;
import static utils.Utils.readPassword;

public class Steps {

    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    private WebDriver driver;

    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }

    public boolean invalidEmail(String email, String password) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.signUp();
        home.fillLoginSignup(email, password);
        return home.containsErrorSignup();
    }

    public boolean incorrectInfantsCount(String fromAirport, String toAirport, String flyOutDay, String flyOutMonth,
                                         String flyOutYear, String flyBackDay, String flyBackMonth, String flyBackYear) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.fillFlyInformationAirports(fromAirport, toAirport);
        home.fillFlyInformationData(flyOutDay, flyOutMonth, flyOutYear, flyBackDay, flyBackMonth, flyBackYear);
        home.setInfantsCount();
        return home.checkInfantsError();
    }

    public boolean languageChange() {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.changeLanguage();
        return home.checkLanguage();
    }

    public boolean successfullyLogin(String email) throws IOException {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.login();
        home.fillLoginSignup(email, readPassword());
        return home.isAccount();
    }

    public boolean sameAirport(String airport) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.fillFlyInformationAirports(airport, airport);
        return home.containsErrorsSameAirport(airport);
    }

    public boolean roomBooking(String destinationCity, String checkinDay, String checkinMonth,
                               String checkinYear, String checkoutDay, String checkoutMonth,
                               String checkoutYear, String firstName, String surname,
                               String email, String phoneNumber, String cardNumber,
                               String cardCVV, String cardholderName,
                               String address, String city, String postcod) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.goToBooking();
        BookingListPage bookingListPage = home.fillBookingInformation(destinationCity, checkinDay, checkinMonth, checkinYear,
                checkoutDay, checkoutMonth, checkoutYear);
        BookingDetailsPage bookingDetailsPage = bookingListPage.selectHotel();
        PaymentPage paymentPage = bookingDetailsPage.bookApartments();
        paymentPage.fillCreditsForBooking(firstName, surname, email, phoneNumber, cardNumber, cardCVV, cardholderName, address, city, postcod);
        return paymentPage.checkTerm();
    }

    public boolean selectFlight(String fromAirport, String toAirport, String flyOutDay, String flyOutMonth,
                                String flyOutYear, String flyBackDay, String flyBackMonth, String flyBackYear) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.fillFlyInformationAirports(fromAirport, toAirport);
        home.fillFlyInformationData(flyOutDay, flyOutMonth, flyOutYear, flyBackDay, flyBackMonth, flyBackYear);
        AboutFlightPage aboutFlightPage = home.letsGo();
        return aboutFlightPage.checkPoints(fromAirport, toAirport);
    }

    public boolean carHire(String cityForCarHire, String pickUpDay, String pickUpMonth, String pickUpYear, String dropOffDay, String dropOffMonth, String dropOffYear, String firstname, String surname, String email, String address, String city) throws InterruptedException {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.clickOnCarHireTab();
        home.fillInformationCarHire(cityForCarHire, pickUpDay, pickUpMonth, pickUpYear, dropOffDay, dropOffMonth, dropOffYear);
        SelectCarsPage selectCarsPage = home.clickOnSelectCars();
        selectCarsPage.clickToSelectCar();
        selectCarsPage.clickToContinueSelectCar();
        selectCarsPage.fillInformation(firstname, surname, email, address, city);
        return selectCarsPage.containsError();
    }

    public boolean unrealAirport(String fromAirport, String unrealAirport) {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.fillFlyInformationAirports(fromAirport, unrealAirport);
        return home.containsErrorsUnrealAirport(unrealAirport);
    }


    public boolean changePassword(String email) throws IOException, InterruptedException {
        MainPage home = new MainPage(driver);
        home.openPage();
        home.login();
        home.fillLoginSignup(email, readPassword());
        AccountSettingsPage accountSettingsPage = home.settingAccount();
        String password = generatePassword(8, ALPHA_CAPS + ALPHA + SPECIAL_CHARS + NUMERIC);
        accountSettingsPage.changePassword(readPassword(), password);
        return accountSettingsPage.checkCaptcha();
    }
}
