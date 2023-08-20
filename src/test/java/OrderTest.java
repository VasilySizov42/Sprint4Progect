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

    public OrderTest(String name, String lastName, String address, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {"Василий",
                 "Сизов",
                "ул.Пушкина, д.15",
                "+71234567887",},

        };
    }
    @Test
    public void orderScooter() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        //System.out.println((driver.getTitle()));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        HomeScooter objHome = new HomeScooter(driver);
        objHome.clickOrderButtonTop();
        OrderScooter objOrder = new OrderScooter(driver);
        objOrder.fillNameField(name);
        objOrder.fillLastNameField(lastName);
        objOrder.fillDestinationAddress(address);
        objOrder.fillPhoneNumber(phone);
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

