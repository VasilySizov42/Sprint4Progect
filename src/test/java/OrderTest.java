import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.HomeScooter;
import pageobject.OrderScooter;

import static org.hamcrest.CoreMatchers.startsWith;
import static pageobject.Constants.ORDER_OBJ_1;
import static pageobject.Constants.ORDER_OBJ_2;

@RunWith(Parameterized.class)
public class OrderTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
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
        HomeScooter objHome = new HomeScooter(driverRule.getDriver());
        objHome.clickOrderButtonTop();
        OrderScooter objOrder = new OrderScooter(driverRule.getDriver());
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
        HomeScooter objHome = new HomeScooter(driverRule.getDriver());
        objHome.clickOrderButtonBottom();
        OrderScooter objOrder = new OrderScooter(driverRule.getDriver());
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

}

