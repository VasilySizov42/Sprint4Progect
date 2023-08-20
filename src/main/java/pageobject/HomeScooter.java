package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeScooter {
    private WebDriver driver;
    //Кнопка "Заказать" в хедере
    private By orderButtonTop = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" в конце страницы
    private By orderButtonBottom = By.xpath("//button/parent::div[@class='Home_FinishButton__1_cWm']");
    //Выпадающий список
    private By accordion = By.className("accordion");
    //Элемент выпадающего списка
    private By accordionElement = By.className("accordion__item");
    //Кнопка элемента выпадающего списка
    private By accordionButton = By.xpath(".//div[@role='button']");
    //Выпадающая часть
    private By accordionAnswer = By.xpath(".//p");
    public HomeScooter(WebDriver driver){
        this.driver = driver;
    }
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }
    public void clickOrderButtonBottom() {
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].scrollIntoView();",
                        driver.findElement(orderButtonBottom));
        new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.elementToBeClickable(By.tagName("button")));
        driver.findElement(orderButtonBottom).click();}
    public String getAccordion(int index) {
        ((JavascriptExecutor)driver).
                executeScript("arguments[0].scrollIntoView();", driver.findElement(accordion));

        List<WebElement> elements = driver.findElements(accordionElement);

        WebElement elt = elements.get(index);

            ((JavascriptExecutor)driver).
                    executeScript("arguments[0].scrollIntoView();", elt);

            elt.findElement(accordionButton).click();
            System.out.println(elt.findElement(accordionButton).getText());
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(elt.findElement(accordionAnswer)));
            return elt.findElement(accordionAnswer).getText();
    }
}
