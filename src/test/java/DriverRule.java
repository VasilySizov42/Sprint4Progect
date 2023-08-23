import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        switch (System.getProperty("browser")) {
            case "firefox":
                setUpFirefox();
                break;
            default:
                setUpChrome();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
    }
    private void setUpFirefox(){
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
    }
    private void setUpChrome(){
        // драйвер для браузера Firefox
        driver = new ChromeDriver();
    }
    @Override
    protected void after() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
