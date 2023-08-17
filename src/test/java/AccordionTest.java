import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomeScooter;
import pageobject.PagesAdresses;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

public class AccordionTest {
    private WebDriver driver;
    /*
        class accordionElemetCheckerClass {

            public int checkAccordionElement(String a, int b) {
                return a + b;
            }
        }

        @RunWith(Parameterized.class)
        public class AccordionElementTest { // создали тестовый класс

            private final String headerExpected;
            private final String answerExpected;

            public AccordionElementTest( String headerExpected, String answerExpected) {
                this.headerExpected = headerExpected;
                this.answerExpected = answerExpected;
            }


        @Parameterized.Parameters
        public Object[] accordionTest() {
            return new Object[][] {
                    { "Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                    { "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."}, // передали тестовые данные
            };
        }

    */
    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        //driver = new ChromeDriver();
        // драйвер для браузера Firefox
        driver = new FirefoxDriver();
        System.out.println((driver.getTitle()));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get(PagesAdresses.HOME);
        HomeScooter obj = new HomeScooter(driver);
        obj.getAccordion();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
