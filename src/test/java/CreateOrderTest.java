import data.DataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import model.ColorOrder;
import model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import rest.ScooterRestUrl;

import java.util.Arrays;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest extends MainTest {

    private Order order;

    public CreateOrderTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {DataGenerator.generatorNewOrder(Arrays.asList(ColorOrder.BLACK))},
                {DataGenerator.generatorNewOrder(Arrays.asList(ColorOrder.GREY))},
                {DataGenerator.generatorNewOrder(Arrays.asList(ColorOrder.GREY, ColorOrder.BLACK))},
                {DataGenerator.generatorNewOrder(null)}
        };
    }

    @Test
    @DisplayName("Check authorization courier of /api/v1/orders")
    @Description("Basic success test for /api/v1/orders")
    public void createNewOrderWithColorTest() {

        Response response = restScooterSend.postRequestAndReturnResponse(order, ScooterRestUrl.ORDER_URL);

        response.then().assertThat()
                .statusCode(201)
                .and().body("track", notNullValue());

        System.out.println(response.getBody().print());
    }
}
