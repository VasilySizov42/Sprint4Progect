import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomeScooter;
import pageobject.OrderScooter;
import pageobject.Constants;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.startsWith;
import static pageobject.Constants.ORDER_OBJ_1;
import static pageobject.Constants.ORDER_OBJ_2;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;
    private final String confirm;

    public OrderTest(String name, String lastName, String address,
                     String phone, String date, String comment, String confirm) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.confirm = confirm;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{ORDER_OBJ_1, ORDER_OBJ_2,};
    }
    @Test
    public void orderScooterTopBtn() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Program Files (x86)/Google/Chrome/chromedriver-win64/chromedriver.exe"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("C:/Program Files (x86)/Google/Chrome/chrome-win64/chrome.exe");

        driver = new ChromeDriver(service, options);
        // драйвер для браузера Firefox
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(Constants.HOME);
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
        MatcherAssert.assertThat("Окно подтверждения заказа не появилось",
                objOrder.getModal().getText(), startsWith(confirm));
    }
    @Test
    public void orderScooterBottomBtn() {
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(Constants.HOME);
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
        MatcherAssert.assertThat("Окно подтверждения заказа не появилось",
                objOrder.getModal().getText(), startsWith(confirm));
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

