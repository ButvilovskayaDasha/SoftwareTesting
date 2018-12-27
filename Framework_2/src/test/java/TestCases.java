import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestCases {

    private Steps steps;

    private final String CORRECTEMAIL = "wilaxu@cliptik.net";
    private final String EMAIL = "Incorrect";
    private final String PASSWORD = "PageObject123";
    private final String FROMAIRPORT = "Malta";
    private final String TOAIRPORT = "Madrid";
    private final String UNREALAIRPORT = "Unicornport1";
    private final String FLYOUTDAY = "29";
    private final String FLYOUTMONTH = "12";
    private final String FLYOUTYEAR = "2018";
    private final String FLYBACKDAY = "30";
    private final String FLYBACKMONTH = "12";
    private final String FLYBACKYEAR = "2018";
    private final String DESTINATIONAIRPORT = "Toronto, ON, Canada";
    private final String FIRSTNAME = "Jack";
    private final String SURNAME = "Daniels";
    private final String PHONENUMBER = "0234783682";
    private final String CARDNUMBER = "379557483958740";
    private final String CARDCVV = "2373";
    private final String CARDHOLDERNAME = "Jack";
    private final String ADDRESS = "address";
    private final String CITY = "city";
    private final String POSTCODE = "028793";
    private final String CITYFORCARHIRE = "krakow - airport - john paul ii - balice";


    private WebDriver driver;

    @BeforeMethod(description = "Open browser")
    public void setUp() {
        steps = new Steps();
        steps.openBrowser();
    }

    @Test(description = "Incorrect Sign Up")
    public void testInvalidEmail() {
        assertTrue(steps.invalidEmail(EMAIL, PASSWORD));
    }

    @Test(description = "Incorrect infants count")
    public void testIncorrectInfantsCount() {
        assertTrue(steps.incorrectInfantsCount(FROMAIRPORT, TOAIRPORT, FLYOUTDAY, FLYOUTMONTH, FLYOUTYEAR, FLYBACKDAY, FLYBACKMONTH, FLYBACKYEAR));
    }

    @Test(description = "Language Change")
    public void testLanguageChange() {
        assertTrue(steps.languageChange());
    }

    @Test(description = "Successfully login")
    public void testSuccessfullyLogin() throws IOException {
        assertTrue(steps.successfullyLogin(CORRECTEMAIL));
    }

    @Test(description = "Same airport")
    public void testSameAirport() {
        assertTrue(steps.sameAirport(FROMAIRPORT));
    }

    @Test(description = "Room booking")
    public void testRoomBooking() {
        assertTrue(steps.roomBooking(DESTINATIONAIRPORT, FLYOUTDAY, FLYOUTMONTH, FLYOUTYEAR, FLYBACKDAY,
                FLYBACKMONTH, FLYBACKYEAR, FIRSTNAME, SURNAME, CORRECTEMAIL, PHONENUMBER,
                CARDNUMBER, CARDCVV, CARDHOLDERNAME, ADDRESS, CITY, POSTCODE));
    }

    @Test(description = "Select flight")
    public void testSelectFlight() {
        assertTrue(steps.selectFlight(FROMAIRPORT, TOAIRPORT, FLYOUTDAY, FLYOUTMONTH, FLYOUTYEAR, FLYBACKDAY, FLYBACKMONTH, FLYBACKYEAR));
    }

    @Test(description = "Car Hire")
    public void testCarHire() throws InterruptedException {
        assertTrue(steps.carHire(CITYFORCARHIRE, FLYOUTDAY, FLYOUTMONTH, FLYOUTYEAR, FLYBACKDAY, FLYBACKMONTH, FLYBACKYEAR, FIRSTNAME, SURNAME, CORRECTEMAIL, ADDRESS, CITY));
    }

    @Test(description = "Select unreal airport")
    public void testSelectUnrealAirport() {
        assertTrue(steps.unrealAirport(FROMAIRPORT, UNREALAIRPORT));
    }

    @Test(description = "Change password captcha")
    public void testChangePasswordCaptcha() throws IOException, InterruptedException {
        assertTrue(steps.changePassword(CORRECTEMAIL));
    }

    @AfterMethod(description = "Close Browser")
    public void tearDown() {
        steps.closeBrowser();
    }
}
