import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class TestCase {

    String url = "https://www.ryanair.com/gb/en/";
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testInvalidEmail() {
    HomePage home = new HomePage(driver);
    SignUpWindow loginpage = home.click();
    loginpage.fill("Incorrect", "PageObject123");
    assertTrue(loginpage.containsError());
    }

}
