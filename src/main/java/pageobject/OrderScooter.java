package pageobject;

import org.openqa.selenium.JavascriptExecutor;
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
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //Кнопка станции метро Бульвар Рокоссовского
    private By RokossovskyBlvdBtn = By.xpath("//li[@class='select-search__row']//button[@value='1']");
    //Поле Телефон
    private By phoneNumber= By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By thenButton= By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле Дата доставки
    private By deliveryDate= By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Кнопка введенной даты
    private By chosenDate = By.xpath("//div[contains(@class,'react-datepicker__day--selected')]");
    //Поле Срок аренды
    private By rentalPeriodField= By.xpath("//div[@class='Dropdown-control']");
    //Элемент выпадающего списка - "трое суток"
    private By rentalPeriod= By.xpath("//div[@class='Dropdown-option' and text()='трое суток']");
    //Чекбокс Цвет самоката - черный
    private By checkBoxBlack= By.xpath("//input[@id='black']");
    //Поле Комментарий для курьера
    private By commentField= By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");

    //Кнопка подтверждения заказа
    private By confirmOrderButton = By.xpath("//button[text()='Да']");

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
        driver.findElement(metroStationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(RokossovskyBlvdBtn)));
        driver.findElement(RokossovskyBlvdBtn).click();
    }
    public void fillPhoneNumber(String phone) {
        driver.findElement(phoneNumber).clear();
        driver.findElement(phoneNumber).sendKeys(phone);
    }
    public void clickThenButton() {
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].scrollIntoView();", driver.findElement(thenButton));
        driver.findElement(thenButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(orderButton)));
    }
    public void fillDeliveryDate(String date) {
        driver.findElement(deliveryDate).clear();
        driver.findElement(deliveryDate).sendKeys(date);
        driver.findElement(chosenDate).click();
    }
    public void checkRentalPeriod() {
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(rentalPeriod)));
        driver.findElement(rentalPeriod).click();
    }
    public void checkScooterColourBlack() {
        driver.findElement(checkBoxBlack).click();
    }
    public void fillComment(String comment) {
        driver.findElement(commentField).clear();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(confirmOrderButton)));
    }
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
        //new WebDriverWait(driver, Duration.ofSeconds(3))
        //        .until(ExpectedConditions.elementToBeClickable(driver.findElement(rentalPeriod)));
    }
}
