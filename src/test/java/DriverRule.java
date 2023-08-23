import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        if (System.getProperty("browser").equals("firefox")) setUpFirefox();
        else setUpChrome();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        //driver.manage().window().maximize();
    }
    private void setUpFirefox(){
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
    }
    private void setUpChrome(){
        // драйвер для браузера Chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/Program Files (x86)/Google/Chrome/chromedriver-win64/chromedriver.exe"))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary("C:/Program Files (x86)/Google/Chrome/chrome-win64/chrome.exe");
        driver = new ChromeDriver(service, options);
    }
    @Override
    protected void after() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
