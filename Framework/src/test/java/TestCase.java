
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static org.testng.Assert.assertTrue;


public class TestCase {

    private final String CITY = "krakow - airport - john paul ii - balice";
    private final String PICK_UP_DAY = "29";
    private final String PICK_UP_MONTH = "11";
    private final String PICK_UP_YEAR = "2018";
    private final String DROP_OFF_DAY = "30";
    private final String DROP_OFF_MONTH = "11";
    private final String DROP_OFF_YEAR = "2018";
    private final String FIRSTNAME = "Qwerty";
    private final String SURNAME = "Qwerty";
    private final String EMAIL = "qwerty@gmail.com";
    private final String ADDRESS = "qwerty";
    private final String CITYOFLIVE = "Qwerty";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

    @Test
    public void testInvalidEmail() {
        HomePage home = new HomePage(driver);
        home.openPage();
        CarHirePage carHirePage = home.clickOnCarHireTab();
        carHirePage.fillInformation(CITY, PICK_UP_DAY, PICK_UP_MONTH, PICK_UP_YEAR, DROP_OFF_DAY, DROP_OFF_MONTH, DROP_OFF_YEAR);
        SelectCarsPage selectCarsPage = carHirePage.clickOnSelectCars();
        AboutCarPage aboutCarPage = selectCarsPage.clickToSelectCar();
        ContactInfoPage contactInfoPage = aboutCarPage.clickToContinueSelectCar();
        contactInfoPage.fillInformation(FIRSTNAME, SURNAME, EMAIL, ADDRESS, CITYOFLIVE);
        assertTrue(contactInfoPage.containsError());
    }

}
