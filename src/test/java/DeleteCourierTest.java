import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import rest.ScooterRestUrl;
import static org.hamcrest.Matchers.equalTo;

public class DeleteCourierTest extends MainTest {

    @Test
    @DisplayName("Check delete courier of /api/v1/courier/:id")
    @Description("Basic delete courier for /api/v1/courier/:id")
    public void checkAllOrdersTest() {

        Response responseDelete = restScooterSend.deleteCourierByIdAndReturnResponse(courierId, courierId.getId(),ScooterRestUrl.DELETE_COURIER_URL);

        responseDelete.then().assertThat()
                .statusCode(200)
                .and().body("ok", equalTo(true));
    }
}
