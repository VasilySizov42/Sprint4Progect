package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderScooter {
    private WebDriver driver;
    //Поле Имя
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле Фамилия
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private By destinationAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Метро
    private By metroStation = By.xpath("//input[@placeholder='* Станция метро']");
    //Поле Телефон
    private By phoneNumber= By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By thenButton= By.xpath("//button/parent::div[@class='Order_NextButton__1_rCA']");
    //Поле Дата доставки
    private By deliveryDate= By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By orderButtonTop = By.className("Button_Button__ra12g");

    public OrderScooter (WebDriver driver){this.driver = driver;}
    public void fillNameField(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillLastNameField(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void fillDestinationAddress(String address) {
        driver.findElement(destinationAddress).clear();
        driver.findElement(destinationAddress).sendKeys(address);
    }
    public void checkMetroStation() {
        driver.findElement(metroStation).click();
        driver.findElement(destinationAddress).click();
    }
    public void fillPhoneNumber(String phone) {
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(phone);
    }
    /*public void clickThenButton() {
        driver.findElement(thenButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(accordionAnswer)));
    }*/
    public void fillDeliveryDate(String date) {
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date);
    }

}
