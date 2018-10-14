import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dasha\\Downloads\\geckodriver.exe");
        String url = "https://www.ryanair.com/gb/en/";
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        driver.get(url);
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(url)) {
            System.out.println("Correct Url");
        } else {
            System.out.println("Incorrect Url \n Actual URL is : " + actualUrl + "\n Expected URL is : " + url);
        }
        driver.findElement(By.xpath("//*[@id=\"flight-search-type-option-one-way\"]")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input")).sendKeys("Krakow");
        driver.findElement(By.xpath("//div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/input")).sendKeys("Eindhoven");
        driver.findElement(By.xpath("//div[4]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")));
        driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")).sendKeys("27");
        driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]")).sendKeys("10");
        driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]")).sendKeys("2018");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/button[2]")));
        driver.findElement(By.id("cookie-popup"));
        driver.findElement(By.xpath("//div[4]/button[2]")).click();
        System.out.println("Page title is: " + driver.getTitle());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]/section/div/div/flight-list/form/div[3]/div/flights-table/div/div[1]/div/flights-table-header/div/div[2]/flights-table-price/div/div[1]/div[2]")));
        driver.close();
    }
}