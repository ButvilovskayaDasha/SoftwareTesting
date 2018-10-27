import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpWindow {

    private WebDriver driver;

    public SignUpWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void fill(String email, String password) {
        driver.findElement(By.xpath("//*[@id=\"email359\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"password365\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@class=\"core-btn-primary\"]")).click();
    }

    public  boolean containsError() {
        return driver.findElements(By.xpath("//*[@class=\"error\"]")).size() > 0;
    }
}
