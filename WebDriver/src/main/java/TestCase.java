import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dasha\\Downloads\\geckodriver.exe");
        String url = "https://www.ryanair.com/gb/en/";
        try {
            WebDriver driver = new FirefoxDriver();
            driver.get(url);
            String actualUrl = driver.getCurrentUrl();
            if (actualUrl.equals(url)) {
                System.out.println("Correct Url");
            } else {
                System.out.println("Incorrect Url \n Actual URL is : " + actualUrl + "\n Expected URL is : " + url);
            }
            Thread.sleep(17000);
            driver.findElement(By.xpath("//*[@id=\"flight-search-type-option-one-way\"]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[1]/div[2]/div[2]/div/div[1]/input")).sendKeys("Krakow");
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/input")).sendKeys("Eindhoven");
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[4]/button[1]")).click();
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")));
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[1]")).sendKeys("30");
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[2]")).sendKeys("10");
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[2]/div[2]/div[1]/div/div[1]/div/div[2]/div[2]/div/input[3]")).sendKeys("2018");
            driver.findElement(By.xpath("/html/body/div[2]/main/article/div[2]/smart-search/div/div[2]/div[1]/div/form/div[4]/button[2]")).click();
            System.out.println("Page title is: " + driver.getTitle());
            Thread.sleep(17000);
            driver.close();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }
    }
}