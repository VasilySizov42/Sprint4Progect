import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import pageobject.HomeScooter;
import pageobject.PagesAdresses;

import java.util.concurrent.TimeUnit;

public class TestActivityChrome {
    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        System.out.println(driver.getTitle());
        HomeScooter obj = new HomeScooter(driver);
        obj.clickOrderButtonBottom();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
