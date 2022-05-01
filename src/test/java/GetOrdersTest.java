import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import rest.ScooterRestUrl;

import static org.hamcrest.Matchers.notNullValue;

public class GetOrdersTest extends MainTest {

    @Test
    @DisplayName("Check all orders tests of /api/v1/orders")
    @Description("Basic success test for /api/v1/orders")
    public void checkAllOrdersTest() {

        Response responseOrder = restScooterSend.getRequestAndReturnResponse(ScooterRestUrl.ORDER_URL);

        responseOrder.then().assertThat()
                .statusCode(200)
                .and().body("orders", notNullValue());
    }
}