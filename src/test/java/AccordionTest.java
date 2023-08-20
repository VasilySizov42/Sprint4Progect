import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomeScooter;
import pageobject.PagesAdresses;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class AccordionTest {
    private WebDriver driver;
    private final int index;
    private final String answer;
    public AccordionTest(int index, String answer) {
        this.index = index;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        };
    }
    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        //System.out.println((driver.getTitle()));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        HomeScooter obj = new HomeScooter(driver);
        Assert.assertEquals(answer,obj.getAccordion(index));

    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}