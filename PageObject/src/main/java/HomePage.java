import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SignUpWindow click() {
        driver.findElement(By.xpath("//*[@id=\"myryanair-auth-signup\"]")).click();
        return new SignUpWindow(driver);
    }
}
