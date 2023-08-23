import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobject.Constants;
import pageobject.HomeScooter;

import static pageobject.Constants.ACCORDION_OBJ_ARR;

@RunWith(Parameterized.class)
public class AccordionTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final int index;
    private final String answer;
    public AccordionTest(int index, String answer) {
        this.index = index;
        this.answer = answer;
    }
    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return ACCORDION_OBJ_ARR;
    }
    @Test
    public void checkingAccordionAnswer() {
        HomeScooter obj = new HomeScooter(driverRule.getDriver());
        Assert.assertEquals("Ответ в строке по индексу "+index+" не соответствует заданному!",
                answer, obj.getAccordion(index));
    }
}
