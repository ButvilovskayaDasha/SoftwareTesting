import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        String url = "https://www.ryanair.com/gb/en/";
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"flight-search-type-option-one-way\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"core-input ng-pristine ng-untouched ng-valid ng-not-empty\"]")).sendKeys("Krakow");
        driver.findElement(By.xpath("//*[@class=\"core-input ng-pristine ng-untouched ng-valid ng-empty\"]")).sendKeys("Eindhoven");
        driver.findElement(By.xpath("//*[@class=\"core-btn-primary core-btn-block core-btn-big\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"dd date-input-0 ng-pristine ng-touched\"]")));
        driver.findElement(By.xpath("//*[@class=\"dd date-input-0 ng-pristine ng-touched\"]")).sendKeys("27");
        driver.findElement(By.xpath("//*[@class=\"mm date-input-1 ng-pristine ng-untouched\"]")).sendKeys("10");
        driver.findElement(By.xpath("//*[@class=\"yyyy date-input-2 ng-pristine ng-untouched\"]")).sendKeys("2018");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"core-btn-primary core-btn-block core-btn-big\"]")));
        driver.findElement(By.id("cookie-popup"));
        driver.findElement(By.xpath("//*[@class=\"core-btn-primary core-btn-block core-btn-big\"]")).click();
        System.out.println("Page title is: " + driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"dd date-input-0 ng-pristine ng-touched\"]")));
        driver.close();
    }
}