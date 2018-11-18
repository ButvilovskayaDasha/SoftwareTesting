package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement inputFirstname;

    @FindBy(xpath = "//*[@id=\"surname\"]")
    private WebElement inputSurname;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement inputAddress;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement inputCity;

    @FindBy(xpath = "//button[@ng-click='confirm()']")
    private WebElement confirmButton;

    public ContactInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void fillInformation(String firstname, String surname, String email, String address, String city) {
        inputFirstname.sendKeys(firstname);
        inputSurname.sendKeys(surname);
        inputEmail.sendKeys(email);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
    }

    public boolean containsError() {
        confirmButton.click();
        return driver.findElements(By.xpath("//span[@data-tooltip='Please fill in your phone number.']")).size() > 0;
    }
}
