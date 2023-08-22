import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomeScooter;
import pageobject.OrderScooter;
import pageobject.PagesAdresses;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;

    public OrderTest(String name, String lastName, String address,
                     String phone, String date, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
//поля для заполнения: Имя, Фамилия, Адрес, Телефон, Дата(дд/мм/гггг), Комментарий
                {"Василий",
                 "Сизов",
                "ул.Пушкина, д.15",
                "+71234567887",
                "25.08.2023",
                "без комментариев",},
                {"Иван",
                 "Петров",
                 "ул.Вагнера, д.4, корп.5",
                 "+712345678864",
                 "25.08.2023",
                 "хочу самокат",},
        };
    }
    @Test
    public void orderScooterTopBtn() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        //System.out.println((driver.getTitle()));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        HomeScooter objHome = new HomeScooter(driver);
        objHome.clickOrderButtonTop();
        OrderScooter objOrder = new OrderScooter(driver);
        objOrder.fillNameField(name);
        objOrder.fillLastNameField(lastName);
        objOrder.fillDestinationAddress(address);
        objOrder.checkMetroStation();
        objOrder.fillPhoneNumber(phone);
        objOrder.clickThenButton();
        objOrder.fillDeliveryDate(date);
        objOrder.checkRentalPeriod();
        objOrder.checkScooterColourBlack();
        objOrder.fillComment(comment);
        objOrder.clickOrderButton();
        objOrder.clickConfirmOrderButton();
        Assert.assertTrue("Окно подтверждения заказа не появилось", objOrder.getModal().isDisplayed());
    }
    @Test
    public void orderScooterBottomBtn() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //System.out.println((driver.getTitle()));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        HomeScooter objHome = new HomeScooter(driver);
        objHome.clickOrderButtonBottom();
        OrderScooter objOrder = new OrderScooter(driver);
        objOrder.fillNameField(name);
        objOrder.fillLastNameField(lastName);
        objOrder.fillDestinationAddress(address);
        objOrder.checkMetroStation();
        objOrder.fillPhoneNumber(phone);
        objOrder.clickThenButton();
        objOrder.fillDeliveryDate(date);
        objOrder.checkRentalPeriod();
        objOrder.checkScooterColourBlack();
        objOrder.fillComment(comment);
        objOrder.clickOrderButton();
        objOrder.clickConfirmOrderButton();
        Assert.assertTrue("Окно подтверждения заказа не появилось", objOrder.getModal().isDisplayed());
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

